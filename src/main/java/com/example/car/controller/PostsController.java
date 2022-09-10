package com.example.car.controller;

import com.example.car.model.Car;
import com.example.car.service.CarService;
import com.example.car.web.UserSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/posts")
@AllArgsConstructor
@Slf4j
public class PostsController {
    private final CarService carService;
    private final UserSession userSession;

    @GetMapping("/")
    String posts(final Model model, final Locale locale) {
        List<Car> cars = carService.finCarsWithEngineGearFILTR();
        model.addAttribute("posts", cars);
        return "posts";
    }
}
