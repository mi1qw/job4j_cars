package com.example.car.controller;

import com.example.car.model.Car;
import com.example.car.model.Status;
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
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/myposts")
@AllArgsConstructor
@Slf4j
public class MyPoststsController {
    private final CarService carService;
    private final UserSession userSession;

    @GetMapping("")
    String posts(final Model model) {
        List<Car> cars = carService.findMyCars();
        Map<Status, List<Car>> statusMap = cars.stream()
                .collect(Collectors.groupingBy(Car::getStatus));
        model.addAttribute("onSale", statusMap.get(Status.onSale));
        model.addAttribute("bought", statusMap.get(Status.bought));
        model.addAttribute("newItem", statusMap.get(Status.newItem));
        model.addAttribute("notActive", statusMap.get(Status.notActive));
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
        boolean isDeleted = carService.deleteCar(id);
        if (!isDeleted) {
            log.error("deleteCar {}", id);
        }
        userSession.setNewCar(null);
        return "redirect:/myposts";
    }

}
