package com.epam.logistic.util;

import java.util.concurrent.Semaphore;

public class IdCounter {
    private int counter;
    private final Semaphore semaphore = new Semaphore(1);

    public IdCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public void getNextId() {
        try {
            this.semaphore.acquire();
            this.counter++;
            Thread.sleep(50);

        } catch (InterruptedException e) {
            // logging
        } finally {
            this.semaphore.release();
        }
    }
}
