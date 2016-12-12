package ua.lisovoy.multithread;

import java.util.Iterator;
import java.util.List;

/**
 * Created by vladimir on 12/8/2016.
 */
public class EchoServerTask implements Runnable {

    private List<EchoSocketStream> socketList;

    public EchoServerTask(List<EchoSocketStream> socketList) {
        this.socketList = socketList;
    }

    @Override
    public void run() {
        while (true) {
            for (EchoSocketStream socketStream : socketList) {
                if (socketStream.isAvailable()) {
                    socketStream.echo();
                }
            }
        }
    }
}
