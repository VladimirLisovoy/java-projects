package ua.lisovoy;

import ua.lisovoy.io.FileManager;
import ua.lisovoy.io.LogAnalyzer;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by dp-ptcstd-1 on 12/6/2016.
 */
public class App {

    public static void main(String[] args) throws IOException {
       // FileManager.copy("C:\\Users\\dp-ptcstd-1\\IdeaProjects\\java-projects\\DirForCopy","C:\\Users\\dp-ptcstd-1\\MoveTest");

      //  FileManager.move("C:\\Users\\dp-ptcstd-1\\IdeaProjects\\java-projects\\DirForCopy","C:\\Users\\dp-ptcstd-1\\MoveTest");
        LogAnalyzer log = new LogAnalyzer();
        System.out.println(log.scanLog("some.log", LocalDateTime.now().minusHours(20), LocalDateTime.now()));

    }
}
