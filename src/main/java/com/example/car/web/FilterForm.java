package com.example.car.web;

import com.example.car.service.BodyService;
import com.example.car.service.GearboxService;
import com.example.car.service.MarkService;
import com.example.car.service.ModelService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@ApplicationScope
@Slf4j
@Data
@AllArgsConstructor
public class FilterForm {
    private final MarkService markService;
    private final ModelService modelService;
    private final BodyService bodyService;
    private final GearboxService gearboxService;
    private Map<String, List> map;
    //    private Map<String, Fieild> map =
//            Map.of(
//                    "mark", new Fieild("Марка", markService.findAll()),
//                    "model", new Fieild<>("Модель", new ArrayList<>()),
//                    "body", new Fieild<>("Кузов", bodyService.findAll())
//            );


    @PostMapping
    public void init() {
        this.map = Map.of(
                "mark", markService.findAll(),
                "model", new ArrayList<>(),
                "body", bodyService.findAll(),
                "gearbox", gearboxService.findAll()
        );
    }

    @AllArgsConstructor
    private static class Fieild<T> {
        private String value;
        private List<T> options;
    }
}
