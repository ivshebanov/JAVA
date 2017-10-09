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

    public static void sendBroadcastMessage(Message message){
        try {
            for (Connection con : connectionMap.values()){
                con.send(message);
            }
        }catch (IOException ex){
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
            super.run();
        }
    }
}
