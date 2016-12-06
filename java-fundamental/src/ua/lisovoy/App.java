package ua.lisovoy;

import ua.lisovoy.io.FileManager;
import ua.lisovoy.io.LogAnalyzer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Created by dp-ptcstd-1 on 12/6/2016.
 */
public class App {

    public static void main(String[] args) throws IOException {

        // FileManager.copy("C:\\Users\\dp-ptcstd-1\\IdeaProjects\\java-projects\\DirForCopy","C:\\Users\\dp-ptcstd-1\\MoveTest");
        FileManager.copy("/Users/vladimir/IdeaProjects/java-projects/CopyDir","/Users/vladimir/IdeaProjects/jva008");

       // FileManager.move("/Users/vladimir/IdeaProjects/java-projects/CopyDir","/Users/vladimir/IdeaProjects/jva008");
        //FileManager.move("C:\\Users\\dp-ptcstd-1\\IdeaProjects\\java-projects\\DirForCopy","C:\\Users\\dp-ptcstd-1\\MoveTest");
       // LogAnalyzer log = new LogAnalyzer();
      //  System.out.println(log.scanLog("some.log", LocalDateTime.now().minusHours(20), LocalDateTime.now()));

    //    String str = "May 07 2016 12:45";
   //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm", Locale.getDefault());

     //   System.out.println(formatter);
    //    LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
    //    System.out.println(dateTime);

    }
}
