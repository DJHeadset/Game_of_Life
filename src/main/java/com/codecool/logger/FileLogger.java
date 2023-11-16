package com.codecool.logger;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {

    private final String logFile = "src/main/resources/csvfile/population.csv";

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

    @Override
    public void ClearFile() {
        try(FileWriter writer = new FileWriter(logFile)) {
            writer.write((""));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
