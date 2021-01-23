package com.epam.logistic.entity;

import com.epam.logistic.warehouse.Warehouse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Van extends Thread {
    private static Logger logger = LogManager.getLogger(Van.class);

    private final int TIME_TO_SLEEP = 700;
    private int productQuantity;
    private Purpose purpose;
    private ProductType productType;
    private Semaphore semaphore;

    public Van(String name, int goodsQuantity, Purpose purpose, ProductType productType, Semaphore semaphore) {
        super.setName(name);
        this.productQuantity = goodsQuantity;
        this.purpose = purpose;
        this.productType = productType;
        this.semaphore = semaphore;
        if(productType == ProductType.HURRYING) {
            this.setPriority(MAX_PRIORITY);
        } else {
            this.setPriority(MIN_PRIORITY);
        }
    }

    @Override
    public void run() {
        try {
            logger.info(getName() + " waiting near the base");
            semaphore.acquire();
            logger.info(getName() + " received a permit to enter the base");
            TimeUnit.MICROSECONDS.sleep(TIME_TO_SLEEP);

            Warehouse.getInstance().update(productQuantity, purpose);

            logger.info(getName() + " leaves base");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            logger.info("PRODUCT: " + Warehouse.getAtomicProductCount());
        }
    }
}
