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
                InputStream inputStream = new FileInputStream(fileInput);
                fileOutput = new File(to);
                OutputStream outputStream = new FileOutputStream(fileOutput);
                int value;
                while ((value = inputStream.read()) != -1) {
                    outputStream.write((byte) value);
                }
                inputStream.close();
                outputStream.close();
            } else {
                fileOutput = new File(to + "\\" + fileInput.getName());
                fileOutput.mkdir();
                File[] files = fileInput.listFiles();
                if (files != null) {
                    for (File file : files) {
                        String nameFile;
                        if (file.isFile()) {
                            nameFile = fileOutput.getCanonicalPath() + "\\" + file.getName();
                        } else {
                            nameFile = fileOutput.getCanonicalPath();
                        }
                        FileManager.copy(file.getCanonicalPath(), nameFile);
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
                    if (file.isFile()) {
                        file.delete();
                    } else {
                        FileManager.delete(file.getCanonicalPath());
                    }
                }
            }
        }
    }
}
