package ua.lisovoy.giggle.db.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladimir on 12.12.16.
 */
public class SharedServer {

    public static void main(String[] args) {
        launchServer();
    }

    private static void launchServer(){
        List<Thread> threadList = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(3000)) {

            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(new SharedServerService(socket));
                threadList.add(thread);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
