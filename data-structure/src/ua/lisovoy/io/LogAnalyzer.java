package ua.lisovoy.io;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vladimir on 12/6/2016.
 */
public class LogAnalyzer {

    private ArrayList<LogToken> logList;

    public LogAnalyzer() {
        this.logList = new ArrayList<LogToken>();
    }

    public ArrayList<LogToken> scanLog(String path, LocalDateTime fromTime, LocalDateTime toTime) throws IOException {

        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                LogToken token = parseLine(line);
                if (token != null && token.isTimeBetween(fromTime, toTime)) {
                    logList.add(token);
                }
            }
        }

        return new ArrayList<LogToken>();
    }

    private LogToken parseLine(String line) {
        String result;
        String regex = "(GET)(POST)";
        Matcher matcher = Pattern.compile(regex).matcher(line);
        while (matcher.find()) {
            result = matcher.group();
            System.out.println(result);
        }
        return null;
    }

}
