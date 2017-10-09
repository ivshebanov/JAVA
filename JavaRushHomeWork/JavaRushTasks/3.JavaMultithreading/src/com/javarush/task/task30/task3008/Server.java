package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private volatile static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт.");
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Сервер запущен.");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Ошибка подключения.");
        }
    }

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Connection con : connectionMap.values()) {
                con.send(message);
            }
        } catch (IOException ex) {
            ConsoleHelper.writeMessage("Ошибка отправки сообщения.");
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            if (socket != null && socket.getRemoteSocketAddress() != null) {
                ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом: " + socket.getRemoteSocketAddress());
            }
            String name = null;
            try (Connection connection = new Connection(socket)) {
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                sendListOfUsers(connection, name);
                serverMainLoop(connection, name);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
            } finally {
                if (name != null) {
                    connectionMap.remove(name);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
                    ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто: " + socket.getRemoteSocketAddress());
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName)
                throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT
                        && !message.getData().isEmpty()) {
                    sendBroadcastMessage(new Message(MessageType.TEXT,
                            userName + ": " + message.getData()));
                } else {
                    ConsoleHelper.writeMessage("Сообщение не является текстом.");
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName)
                throws IOException {
            for (Map.Entry<String, Connection> el : connectionMap.entrySet()) {
                if (!el.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, el.getKey()));
                }
            }
        }

        private String serverHandshake(Connection connection)
                throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();
                if (answer.getType() == MessageType.USER_NAME
                        && !answer.getData().isEmpty()
                        && !connectionMap.containsKey(answer.getData())) {
                    connectionMap.put(answer.getData(), connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return answer.getData();
                }
            }
        }
    }
}