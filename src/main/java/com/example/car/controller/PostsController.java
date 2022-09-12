package com.example.car.controller;

import com.example.car.dto.FilterDto;
import com.example.car.model.Car;
import com.example.car.service.CarService;
import com.example.car.web.UserSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/posts")
@AllArgsConstructor
@Slf4j
public class PostsController {
    private final CarService carService;
    private final UserSession userSession;

    @GetMapping("/")
    String posts(final Model model) {

//        FilterDto filter = FilterDto.builder()
//                .mark(1)
//                .yearFrom((short) 2000)
//                .yearBefore((short) 2030)
//                .odometerFrom(20)
//                .odometerBefore(100)
//                .build();
//        model.addAttribute("filter", filter);

        model.addAttribute("filter",
                userSession.getFilterForm().getFilterDto());


        List<Car> cars = carService.finCarsWithEngineGearFILTR();
        model.addAttribute("posts", cars);
        return "posts";
    }

    //    ResponseEntity<?>
    @PostMapping("/")
    String filterForm(final @ModelAttribute(name = "filter") FilterDto filterDto,
                      final Model model) {
        log.info("{}", filterDto);

        List<Car> cars = carService.filterForm(filterDto);
        model.addAttribute("posts", cars);


        model.addAttribute("filter",
                userSession.getFilterForm().getFilterDto());
//        return new ResponseEntity<>(HttpStatus.OK);
        return "posts";
    }
}
