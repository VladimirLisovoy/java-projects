package ua.lisovoy.io;

import java.time.LocalDateTime;

/**
 * Created by vladimir on 12/6/2016.
 */
public class LogToken {

    private final LocalDateTime time;
    private final HttpMethod method;
    private final String message;

    public LogToken(LocalDateTime time, HttpMethod method, String message) {
        this.time = time;
        this.method = method;
        this.message = message;
    }

    public boolean isTimeBetween(LocalDateTime timeFrom, LocalDateTime timeTo){
        return time != null && time.isAfter(timeFrom) && time.isBefore(timeTo);
    }

    @Override
    public String toString() {
        return "LogToken{" +
                "time=" + time +
                ", method=" + method +
                ", message='" + message + '\'' +
                '}';
    }
}
