package ua.lisovoy.multithread;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EchoServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        List<Socket> socketList = Collections.synchronizedList(new ArrayList<Socket>());
        try {
            serverSocket = new ServerSocket(3000);
            EchoServerTask serverTask = new EchoServerTask(socketList);
            Thread thread = new Thread(serverTask);
            thread.start();
            System.out.println("Server started...");

            while (true) {
                Socket socket = serverSocket.accept();
                socketList.add(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
                System.out.println("Server finished.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
