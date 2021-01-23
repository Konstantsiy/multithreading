package com.epam.logistic.entity;

import com.sun.javafx.css.CssError;

import java.util.concurrent.Semaphore;

public class Inspector {
    public Semaphore semaphore;

    public Inspector(int capacity) {
        this.semaphore = new Semaphore(capacity);
    }
}
