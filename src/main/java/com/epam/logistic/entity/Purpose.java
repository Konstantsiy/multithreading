package com.epam.logistic.entity;

public enum Purpose {
    LOADING ("loading"),
    UNLOADING ("unloading");

    private String purpose;

    Purpose(String type) {
        this.purpose = type;
    }

    public String getPurpose() {
        return purpose;
    }
}
