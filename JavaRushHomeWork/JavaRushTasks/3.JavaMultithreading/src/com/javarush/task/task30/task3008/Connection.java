package com.javarush.task.task30.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class Connection implements Closeable {
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        this.out = (ObjectOutputStream) socket.getOutputStream();
        this.in = (ObjectInputStream) socket.getInputStream();
    }

    private void send(Message message) throws IOException {
        synchronized (socket) {
            //должен сериализовать message
        }
    }

    private Message receive() throws IOException, ClassNotFoundException {
        synchronized (socket) {
            //должен десериализовать данные из ObjectInputStream
        }
        return new Message(MessageType.NAME_ACCEPTED);
    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }


    @Override
    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
