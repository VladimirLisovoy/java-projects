package ua.lisovoy.multithread;

import java.net.Socket;
import java.util.List;

/**
 * Created by dp-ptcstd-1 on 12/8/2016.
 */
public class EchoServerTask implements Runnable {

    private List<Socket> socketList;

    public EchoServerTask(List<Socket> socketList) {
        this.socketList = socketList;
    }

    @Override
    public void run() {

    }
}
