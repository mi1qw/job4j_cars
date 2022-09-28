package com.example.car.controller;

import com.example.car.dto.FilterDto;
import com.example.car.dto.PostDto;
import com.example.car.dto.PostMapper;
import com.example.car.model.Car;
import com.example.car.service.CarService;
import com.example.car.service.CityService;
import com.example.car.util.CarModfctn;
import com.example.car.util.FilterForm;
import com.example.car.util.PathForm;
import com.example.car.web.UserSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
@AllArgsConstructor
@Slf4j
public class PostsController {
    private final CarService carService;
    private final UserSession userSession;
    private final PostMapper postMapper;
    private final CityService cityService;
    private final PathForm pathForm;

    @GetMapping("")
    String posts(final @ModelAttribute(name = "filter") FilterDto filterDto,
                 final Model model) {
        FilterDto filterDto1;
        if (filterDto.getSort() == null) {
            filterDto1 = userSession.getFilterForm().getFilterDto();
        } else {
            filterDto1 = filterDto;
        }

        List<Car> cars = carService.filterForm(filterDto1);
        cars.forEach(n -> n.setCity(cityService.findById(n.getCity().getId())));
        model.addAttribute("posts", cars);
        model.addAttribute("filter", filterDto1);


        cars.forEach(n -> log.info("{}", n.getId()));

        //        List<Car> cars = carService.finCarsWithEngineGearFILTR();
//        model.addAttribute("posts", cars);
        return "posts";
    }

    @GetMapping("/{id}")
    String carPost(final @PathVariable("id") Long id,
                   final Model model) {
        CarModfctn carModfctn = carService.findCarPost(id);
        PostDto postDto = postMapper.carToPostDto(carModfctn.car(), carModfctn.modification());
        model.addAttribute("post", postDto);
        userSession.setNewCar(carModfctn.car());

        FilterForm filterForm = userSession.getFilterForm();
        if (filterForm.isEmpty()) {
            pathForm.carToFilterDto(carModfctn.car());
        }
        return "carPost";
    }

//    @PostMapping("")
//    String filterForm(final @ModelAttribute(name = "filter") FilterDto filterDto,
//                      final Model model) {
//        log.info("{}", filterDto);
//        List<Car> cars = carService.filterForm(filterDto);
//        model.addAttribute("posts", cars);
//        model.addAttribute("filter",
//                userSession.getFilterForm().getFilterDto());
//        return "posts";
//    }

    @GetMapping("/find/{nameFilter}")
    public String back(final @PathVariable("nameFilter") String nameFilter) {
        userSession.getFilterForm().sliceFilter(nameFilter);
        return "redirect:/posts";
    }
}
