package com.example.car.controller;

import com.example.car.store.CarStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/cars")
public class CarForm {
    private final CarStore carStore;

    public CarForm(final CarStore carStore) {
        this.carStore = carStore;
    }

    @GetMapping("/add")
    public String add(final Model model) {
        return "addCar";
    }
}
