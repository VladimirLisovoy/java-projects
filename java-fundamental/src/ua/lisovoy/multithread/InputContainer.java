package ua.lisovoy.multithread;

import ua.lisovoy.serialization.Message;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by dp-ptcstd-1 on 12/7/2016.
 */
public class InputContainer implements Runnable{

    private ArrayList<String> inputList;

    public InputContainer(ArrayList<String> inputList) {
        this.inputList = inputList;
    }

    public void save (){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("input.list"))) {
            for (String input : inputList) {
                bw.write(input);
                bw.newLine();
            }
            System.out.println("Saved to file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            save();
        }
    }
}
