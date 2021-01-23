package com.epam.logistic.main;

import com.epam.logistic.entity.Van;
import com.epam.logistic.reader.DataReader;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static final String FILENAME = "/src/main/resources/data/vans.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Semaphore semaphore = new Semaphore(1, true);
        DataReader dataReader = new DataReader(semaphore);
        List<Van> vansList = dataReader.readFromFile(FILENAME);
        for(Van van : vansList) {
            van.start();
        }
    }
}
