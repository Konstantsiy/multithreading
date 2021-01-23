package com.epam.logistic.factory;

import com.epam.logistic.entity.Van;
import com.epam.logistic.entity.ProductType;
import com.epam.logistic.entity.Purpose;

import java.util.concurrent.Semaphore;

public class DeliveryVanFactory {

    public DeliveryVanFactory() {}

    public Van createDeliveryVan(String name, int goodsQuantity, Purpose purpose, ProductType productType, Semaphore semaphore) {
        return new Van(name, goodsQuantity, purpose, productType, semaphore);
    }
}
