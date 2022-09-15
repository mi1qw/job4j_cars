package com.example.car.web;

import com.example.car.service.*;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.HashMap;
import java.util.Map;

@Component
@ApplicationScope
@Slf4j
@Data
@AllArgsConstructor
public class AppScope {
    private final MarkService markService;
    private final ModelService modelService;
    private final BodyService bodyService;
    private final GearboxService gearboxService;
    private final EngineService engineService;
    private final TransmissionService transmissionService;
    private final SortService sortService;
    private Map<String, Map<Long, ?>> filterMap;

    @PostConstruct
    public void init() {
        this.filterMap = Map.of(
                "mark", markService.findAllMap(),
                "model", new HashMap<>(),
                "body", bodyService.findAllMap(),
                "gearbox", gearboxService.findAllMap(),
                "engine", engineService.findAllMap(),
                "transmission", transmissionService.findAllMap(),
                "sort", sortService.findAllMap()
        );
//        filterMap.get(1).get(1);

//        this.filterMap = Map.of(
//                "mark", new Fieild<>(null, markService.findAll()),
//                "model", new Fieild<>(null, new ArrayList<>()),
//                "body", new Fieild<>(null, bodyService.findAll())
//        );
    }
}