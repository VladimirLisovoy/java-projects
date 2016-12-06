package ua.lisovoy.data_structure;

/**
 * Created by vladimir on 05.12.16.
 */
public class App {
    public static void main(String[] args) {
        int val = Math.abs(Integer.MIN_VALUE);
        System.out.println(val < 0 ? Math.abs(val-1) : val);
    }
}
