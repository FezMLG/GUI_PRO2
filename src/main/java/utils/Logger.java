package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private String fileName;

    public Logger() {
        String filename = "logs.txt";
        String path = "./";
        this.fileName = filename + path;
    }

    public void log(String log) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            StackTraceElement trace = Thread.currentThread().getStackTrace()[2];
            bw.write(
                    LocalDateTime.now() + " - " +
                            trace.getClassName() + " - " +
                            trace.getMethodName() + ": " + log
            );
            bw.newLine();
            bw.close();
        } catch (IOException ignored) {
            System.out.println("Failed to save");
        }

    }
}
