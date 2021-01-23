package com.epam.logistic.warehouse;

import com.epam.logistic.entity.Purpose;

import java.util.concurrent.atomic.AtomicInteger;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private static final AtomicInteger atomicProductCount = new AtomicInteger(0);

    private Warehouse() {}

    public static Warehouse getInstance() {
        return instance;
    }

    public static AtomicInteger getAtomicProductCount() {
        return atomicProductCount;
    }

    public void update(final int delta, Purpose purpose) {
        if(purpose == Purpose.LOADING) {
            atomicProductCount.updateAndGet(n -> n - delta);
        } else {
            atomicProductCount.updateAndGet(n -> n + delta);
        }
    }
}
