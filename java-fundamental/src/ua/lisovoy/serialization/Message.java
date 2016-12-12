package ua.lisovoy.serialization;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by vladimir on 12/7/2016.
 */
public class Message implements Serializable {

    private static final long serialVersionUID = -1L;
    private final int id;
    private final Date date;
    private final String content;

    public Message(int id, Date date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }

    public Message(int id, long date, String content) {
        this.id = id;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        this.date = calendar.getTime();
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}
