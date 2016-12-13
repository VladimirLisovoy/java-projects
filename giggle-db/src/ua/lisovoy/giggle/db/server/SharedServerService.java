package ua.lisovoy.giggle.db.server;

import ua.lisovoy.giggle.db.query.Query;

import java.io.*;
import java.net.Socket;

/**
 * Created by vladimir on 12.12.16.
 */
public class SharedServerService implements Runnable {

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public SharedServerService(Socket socket) {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            DataBaseManager dbManager = new DataBaseManager();

            while (true) {
                if (bufferedReader.ready()) {
                    dbManager.pull(getQuery());
                    for (String resultLine : dbManager.push()) {
                        bufferedWriter.write(resultLine);
                    }
                    bufferedWriter.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getQuery() throws IOException{
        StringBuilder queryBuilder = new StringBuilder();
        String value;
        while ((value = bufferedReader.readLine()) != null) {
            queryBuilder.append(value);
        }
        return queryBuilder.toString();
    }
}
