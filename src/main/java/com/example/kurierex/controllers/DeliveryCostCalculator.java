package com.example.kurierex.controllers;

import com.example.kurierex.models.DeliveryCostModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/delivery", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeliveryCostCalculator {

    @GetMapping(path = "/cost")
    @ResponseBody
    public Object getCost(@RequestParam String length, @RequestParam String height, @RequestParam String width) {

        double lengthy = Double.parseDouble(length);
        double heighty = Double.parseDouble(height);
        double widthy = Double.parseDouble(width);
        double dimensionalWeight = lengthy * heighty * widthy / 5000;
        try {
            if (dimensionalWeight < 50) {
                return getPackageCost(dimensionalWeight);
            } else if (dimensionalWeight >= 50) {
                return getPaletaCost(dimensionalWeight);
            }
        } catch (Exception e) {
            return e;
        }
        return null;
    }

    public DeliveryCostModel getPackageCost(double dimensionalWeight) throws Exception {

        DeliveryCostModel model = new DeliveryCostModel(0, 0);

        if (dimensionalWeight < 2) {
            model.setBrutto(15.85);
            model.setNetto(12.89);
        } else if (dimensionalWeight >= 2 && dimensionalWeight < 5) {
            model.setBrutto(16.58);
            model.setNetto(13.48);
        } else if (dimensionalWeight >= 5 && dimensionalWeight < 10) {
            model.setBrutto(17.08);
            model.setNetto(13.89);
        } else if (dimensionalWeight >= 10 && dimensionalWeight < 20) {
            model.setBrutto(18.68);
            model.setNetto(15.19);
        } else if (dimensionalWeight >= 20 && dimensionalWeight < 31.5) {
            model.setBrutto(19.89);
            model.setNetto(16.17);
        } else if (dimensionalWeight >= 31.5 && dimensionalWeight < 40) {
            model.setBrutto(61.49);
            model.setNetto(49.99);
        } else if (dimensionalWeight >= 40 && dimensionalWeight < 50) {
            model.setBrutto(67.64);
            model.setNetto(54.99);
        } else {
            throw new Exception("Paczka jest zbyt duża, prosimy o wybranie opcji 'Paleta'.");
        }

        return model;
    }

    public DeliveryCostModel getPaletaCost(double dimensionalWeight) throws Exception {

        DeliveryCostModel model = new DeliveryCostModel(0, 0);

        if (dimensionalWeight >= 50 && dimensionalWeight < 300) {
            model.setBrutto(159.89);
            model.setNetto(129.99);
        } else if (dimensionalWeight >= 300 && dimensionalWeight < 500) {
            model.setBrutto(196.79);
            model.setNetto(159.99);
        } else if (dimensionalWeight >= 500 && dimensionalWeight < 700) {
            model.setBrutto(282.89);
            model.setNetto(229.99);
        } else {
            throw new Exception("Paczka jest zbyt duża. Przepraszamy, ale nasza firma nie jest w stanie jej dostarczyć.");
        }
        return model;
    }


}
