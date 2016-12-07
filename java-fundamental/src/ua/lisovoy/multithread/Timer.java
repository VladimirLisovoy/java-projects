package ua.lisovoy.multithread;

/**
 * Created by dp-ptcstd-1 on 12/7/2016.
 */
public class Timer implements Runnable {

    private final String name;
    private int secondTillFinish;

    public Timer(String name, int secondTillFinish) {
        this.name = name;
        this.secondTillFinish = secondTillFinish;
    }

    @Override
    public void run() {
        for (int i = 0; i < secondTillFinish; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Name: " + name + ", seconds till finish: " + (secondTillFinish - i));
        }
        System.out.println(name + " finished");
    }
}
