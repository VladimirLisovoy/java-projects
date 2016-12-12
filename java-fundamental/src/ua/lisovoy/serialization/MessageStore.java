package ua.lisovoy.serialization;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created vladimir on 12/7/2016.
 */
public interface MessageStore {

    List<Message> read();

    void persist(Collection<Message> list);

}
