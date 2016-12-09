package ua.lisovoy.multithread;

import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * Created by vladimir on 12/8/2016.
 */
public class EchoServerTask implements Runnable {

    private List<Socket> socketList;

    public EchoServerTask(List<Socket> socketList) {
        this.socketList = socketList;
    }

    @Override
    public void run() {
        while (true) {

            for (int i = 0; i < socketList.size(); i++) {
                try {
                    if (socketList.get(i).getInputStream().available() > 0) {

                        BufferedReader bufferedReader = new BufferedReader(
                                new InputStreamReader(socketList.get(i).getInputStream()));

                        if (bufferedReader.ready()) {
                            String line = bufferedReader.readLine();
                            BufferedWriter bufferedWriter = new BufferedWriter(
                                    new OutputStreamWriter(socketList.get(i).getOutputStream()));
                            bufferedWriter.write(line);
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
