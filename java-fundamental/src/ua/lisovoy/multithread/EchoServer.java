package ua.lisovoy.multithread;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EchoServer {

    public static void main(String[] args) {
        List<EchoSocketStream> socketList = Collections.synchronizedList(new CopyOnWriteArrayList<EchoSocketStream>());
        try (ServerSocket serverSocket = new ServerSocket(3000)) {
            Thread thread = new Thread(new EchoServerTask(socketList));
            thread.start();
            System.out.println("Server started...");
            while (true) {
                Socket socket = serverSocket.accept();
                socketList.add(new EchoSocketStream(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
