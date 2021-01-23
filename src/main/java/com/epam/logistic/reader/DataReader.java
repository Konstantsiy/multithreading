package com.epam.logistic.reader;

import com.epam.logistic.entity.Van;
import com.epam.logistic.entity.ProductType;
import com.epam.logistic.entity.Purpose;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class DataReader {
    private final String FIELD_SEPARATOR = "---";
    private final int NAME_INDEX = 0;
    private final int COUNT_INDEX = 1;
    private final int PURPOSE_INDEX = 2;
    private final int PRODUCT_TYPE_INDEX = 3;

    private Semaphore semaphore;

    public DataReader(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public List<Van> readFromFile(String filename) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filename);
        Scanner scanner = new Scanner(fileReader);
        List<Van> vans = new ArrayList<>();
        try {
            while(scanner.hasNextLine()) {
                String deliveryVanLine = scanner.nextLine();
                String[] params = deliveryVanLine.split(FIELD_SEPARATOR);
                String name = params[NAME_INDEX];
                int productCount = Integer.parseInt(params[COUNT_INDEX]);
                Purpose purpose = Purpose.valueOf(params[PURPOSE_INDEX]);
                ProductType type = ProductType.valueOf(params[PRODUCT_TYPE_INDEX]);
                vans.add(new Van(name, productCount, purpose, type, semaphore));
            }
        } finally {
            scanner.close();
        }
        return vans;
    }
}
