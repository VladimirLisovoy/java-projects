package ua.lisovoy;

import ua.lisovoy.io.FileManager;
import ua.lisovoy.io.LogAnalyzer;
import ua.lisovoy.io.LogToken;
import ua.lisovoy.multithread.*;
import ua.lisovoy.multithread.Timer;
import ua.lisovoy.serialization.Message;
import ua.lisovoy.serialization.SerializationMessageStore;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by dp-ptcstd-1 on 12/6/2016.
 */
public class App {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // FileManager.copy("C:\\Users\\dp-ptcstd-1\\IdeaProjects\\java-projects\\DirForCopy","C:\\Users\\dp-ptcstd-1\\MoveTest");
        // FileManager.copy("/Users/vladimir/IdeaProjects/java-projects/CopyDir","/Users/vladimir/IdeaProjects/jva008");

        // FileManager.move("/Users/vladimir/IdeaProjects/java-projects/CopyDir","/Users/vladimir/IdeaProjects/jva008");
        // FileManager.move("C:\\Users\\dp-ptcstd-1\\IdeaProjects\\java-projects\\DirForCopy","C:\\Users\\dp-ptcstd-1\\MoveTest");

        // LogAnalyzer log = new LogAnalyzer();
        // ArrayList<LogToken> array = log.scanLog("some.log", LocalDateTime.now().minusYears(1), LocalDateTime.now());
        // System.out.println(array);

       // Collection<Message> messages = new ArrayList<Message>();
       // messages.add(new Message(1, new Date(), "First mess"));
      //  messages.add(new Message(2, new Date(), "Second mess"));
       // messages.add(new Message(3, new Date(), "Last mess"));
      //  SerializationMessageStore sms = new SerializationMessageStore();
      //  sms.persist(messages);

       // System.out.println(sms.read());
/*
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Timer("Timer: " + i, (i+1) * 20));
            threadList.add(thread);
            thread.start();
        }

        System.out.println("Main finished");
        */

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ArrayList<String> inputList = new ArrayList<>();
        Thread thread = new Thread(new InputContainer(inputList));
        thread.start();
        while(true) {
            inputList.add(bufferedReader.readLine());
        }

    }
}
