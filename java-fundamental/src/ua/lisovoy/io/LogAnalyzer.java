package ua.lisovoy.io;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        File file = new File(path);
        if (file.exists()) {
            BufferedReader buffer = new BufferedReader(new FileReader(path));
            String line;
            while ((line = buffer.readLine()) != null) {
                LogToken token = parseLine(line);
                if (token != null && token.isTimeBetween(fromTime, toTime)) {
                    logList.add(token);
                }
            }
            return new ArrayList<LogToken>();
        }
        return null;
    }

    private LogToken parseLine(String line) {

        HttpMethod httpMethod = null;
        String regexHttp = "(GET)|(POST)";
        Matcher matcher = Pattern.compile(regexHttp).matcher(line);
        while (matcher.find()) {
            httpMethod = HttpMethod.valueOf(matcher.group());
        }

        String message = null;
        String regexMess = "(?<=GET|POST).*";
        Matcher matcherMess = Pattern.compile(regexMess).matcher(line);
        while (matcherMess.find()) {
            message = matcherMess.group();
        }

        LocalDateTime time = null;
        String timeInChar = null;
        String regexTime = "(?<=\\[).*?(?=\\])";
        Matcher matcherTime = Pattern.compile(regexTime).matcher(line);
        while (matcherTime.find()) {
            timeInChar = matcherTime.group();
        }
        System.out.println(timeInChar);
        timeInChar = "07/Mar/2004:16:05:49";
        if (timeInChar != null) {
            time = LocalDateTime.parse(timeInChar, DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss"));
        }
        System.out.println(time);

        if (httpMethod != null && message != null && time != null){
            return new LogToken(time, httpMethod, message);
        }
        return null;
    }

}
