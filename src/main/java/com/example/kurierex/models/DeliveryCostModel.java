package com.example.kurierex.models;

public class DeliveryCostModel {

    private double netto;
    private double brutto;

    public DeliveryCostModel(double netto, double brutto) {
        this.netto = netto;
        this.brutto = brutto;
    }

    public double getNetto() {
        return netto;
    }

    public void setNetto(double netto) {
        this.netto = netto;
    }

    public double getBrutto() {
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }
}
