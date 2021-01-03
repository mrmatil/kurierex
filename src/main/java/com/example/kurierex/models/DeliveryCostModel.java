package com.example.kurierex.models;

public class DeliveryCostModel {

    private double price;

    public DeliveryCostModel(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
