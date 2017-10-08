package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Введите порт: ");
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            System.out.println("Не создался ServerSocket");
        }
        System.out.println("Сервер запушен!");
        assert serverSocket != null;
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (Exception e) {
            System.out.println("Не создался Socket");
            try {
                serverSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
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
