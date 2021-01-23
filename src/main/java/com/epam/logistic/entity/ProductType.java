package com.epam.logistic.entity;

public enum ProductType {
    HURRYING ("HURRYING"),
    NOT_HURRYING ("NOT_HURRYING");

    private String type;

    ProductType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
