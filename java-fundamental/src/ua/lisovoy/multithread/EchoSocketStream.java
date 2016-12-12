package ua.lisovoy.multithread;

import java.io.*;
import java.net.Socket;

public class EchoSocketStream {

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public EchoSocketStream(Socket socket) {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isAvailable() {
        try {
            return bufferedReader.ready();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void echo() {
        try {
            bufferedWriter.write(bufferedReader.readLine());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
