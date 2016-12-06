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
        log.scanLog("64.242.88.10 - - [07/Mar/2004:16:06:51 -0800] \"GET /twiki/bin/rdiff/TWiki/NewUserTemplate?rev1=1.3&rev2=1.2 HTTP/1.1\" 200 4523", LocalDateTime.now(), LocalDateTime.now());

    }
}
