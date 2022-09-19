package com.example.car.controller;

import com.example.car.model.Car;
import com.example.car.service.CarService;
import com.example.car.web.UserSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/myposts")
@AllArgsConstructor
@Slf4j
public class MyPoststsController {
    private final CarService carService;
    private final UserSession userSession;

    @GetMapping("")
    String posts(final Model model) {
        List<Car> cars = carService.findMyCar();
        model.addAttribute("posts", cars);
        return "myPosts";
    }

    @PostMapping("/status")
    ResponseEntity<?> postsStatus(final @RequestParam("id") Long id,
                                  final @RequestParam("value") boolean status) {
        if (carService.chageStatus(id, status)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/deleteCar/{id}")
    String deleteCar(final @PathVariable("id") Long id) {
        carService.deleteCar(id);
        return "redirect:/myposts";
    }

}
