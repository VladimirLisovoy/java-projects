package ua.lisovoy.serialization;

import java.io.*;
import java.util.Collection;
import java.util.List;

public class SerializationMessageStore implements MessageStore {

    @Override
    public List<Message> read() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("sfile.out")))) {
            List<Message> list = (List<Message>) ois.readObject();
            return list;
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void persist(Collection<Message> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("sfile.out")))) {
            oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
