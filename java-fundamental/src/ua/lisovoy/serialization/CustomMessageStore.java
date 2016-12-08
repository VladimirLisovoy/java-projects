package ua.lisovoy.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by vladimir on 12/7/2016.
 */
public class CustomMessageStore implements MessageStore {

    @Override
    public List<Message> read() {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("cfile.out")))) {
            int length = dis.readInt();
            int i = 0;
            List<Message> list = new ArrayList<>();
            while (i < length) {
                int id = dis.readInt();
                long millis = dis.readLong();
                int lengthCharByte = dis.readInt();
                char[] contentChar = new char[new byte[lengthCharByte].length];
                int j = 0;
                while (j < lengthCharByte) {
                    contentChar[j] = dis.readChar();
                    j++;
                }
                String content = String.copyValueOf(contentChar);
                list.add(new Message(id, millis, content));
                i++;
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void persist(Collection<Message> list) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("cfile.out")))) {
            dos.writeInt(list.size());
            for (Message message : list) {
                dos.writeInt(message.getId());
                dos.writeLong(message.getDate().getTime());
                dos.writeInt(message.getContent().getBytes().length);
                dos.writeChars(message.getContent());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
