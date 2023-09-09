package com.codecool.logger;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {

    private final String logFile = "c:\\Users\\zolta\\Desktop\\Population.csv";

    @Override
    public void LogInfo(int population) {
        try(FileWriter writer = new FileWriter(logFile, true)){
            writer.write(population + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void logError() {

    }
}
