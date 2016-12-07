package ua.lisovoy.serialization;

import java.io.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by vladimir on 12/7/2016.
 */
public class CustomMessageStore implements MessageStore {

    @Override
    public List<Message> read() {
        try (DataInputStream dos = new DataInputStream(new BufferedInputStream(new FileInputStream("cfile.out")))) {
       //     for (Message message : list) {

           // }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void persist(Collection<Message> list) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("cfile.out")))) {
            for (Message message : list) {
                dos.writeInt(message.getId());
                dos.writeLong(message.getDate().getTime());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
