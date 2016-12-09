package ua.lisovoy.multithread;

import java.io.*;
import java.net.Socket;

/**
 * Created by dp-ptcstd-1 on 12/8/2016.
 */
public class EchoClient {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 3000);
            System.out.println("Client Started");
            InputStream inputStream = System.in;
            BufferedReader bufferedReaderIn = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReaderServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                if (bufferedReaderIn.ready()) {
                    bufferedWriter.write(bufferedReaderIn.readLine());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
                if (bufferedReaderServer.ready()){
                    System.out.println(bufferedReaderServer.readLine());
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("Client done.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
