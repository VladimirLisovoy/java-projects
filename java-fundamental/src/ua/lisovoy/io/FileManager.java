package ua.lisovoy.io;

import java.io.*;

/**
 * Created by vladimir on 12/5/2016.
 */
public class FileManager {

    public static int calculateFiles(String path) throws IOException {
        File filePath = new File(path);
        if (filePath.exists()) {
            File[] files = filePath.listFiles();
            int fileCounter = 0;
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        fileCounter++;
                    } else {
                        fileCounter += FileManager.calculateFiles(file.getCanonicalPath());
                    }
                }
            }
            return fileCounter;
        } else {
            return 0;
        }
    }

    public static int calculateDirs(String path) throws IOException {
        File filePath = new File(path);
        if (filePath.exists()) {
            File[] files = filePath.listFiles();
            int dirCounter = 0;
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        dirCounter++;
                        dirCounter += FileManager.calculateDirs(file.getCanonicalPath());
                    }
                }
            }
            return dirCounter;
        } else {
            return 0;
        }
    }

    public static void copy(String from, String to) throws IOException {
        File fileInput = new File(from);
        File fileOutput;
        if (fileInput.exists()) {
            if (fileInput.isFile()) {
                fileOutput = new File(to);

                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileInput));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutput));

                int value;
                while ((value = bufferedReader.read()) != -1) {
                    bufferedWriter.write(value);
                }
                bufferedReader.close();
                bufferedWriter.close();
            } else {
                fileOutput = new File(to + fileInput.separator + fileInput.getName());
                fileOutput.mkdir();
                File[] files = fileInput.listFiles();
                if (files != null) {
                    for (File file : files) {
                        String fullPathTo = fileOutput.getCanonicalPath() + (file.isFile() ?  fileInput.separator + file.getName() : "");
                        FileManager.copy(file.getCanonicalPath(), fullPathTo);
                    }
                }
            }
        }
    }

    public static void move(String from, String to) throws IOException {
        File fileInput = new File(from);
        if (fileInput.exists()) {
            FileManager.copy(fileInput.getCanonicalPath(), to);
            FileManager.delete(from);
        }
    }

    public static void delete(String path) throws IOException {
        File fileInput = new File(path);
        if (fileInput.exists()) {
            File[] files = fileInput.listFiles();
            if (files != null) {
                for (File file : files) {
                    FileManager.delete(file.getCanonicalPath());
                    file.delete();
                }
            }
        }
        fileInput.delete();
    }
}
