package com.example.kurierex.controllers;

import com.example.kurierex.models.DeliveryCostModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/delivery", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeliveryCostCalculator {

    private DeliveryCostModel model;

    @GetMapping(path = "/cost")
    public DeliveryCostModel getCost() {
        model = new DeliveryCostModel(12.0,15.0);
        return model;
    }

}
