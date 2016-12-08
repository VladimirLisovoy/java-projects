package ua.lisovoy.multithread;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EchServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        List<Socket> socketList = Collections.synchronizedList(new ArrayList<Socket>());
        try {
            serverSocket = new ServerSocket(3000);

            while (true) {
                Socket socket = serverSocket.accept();
                socketList.add(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
