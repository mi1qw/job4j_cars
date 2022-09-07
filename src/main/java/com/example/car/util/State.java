package com.example.car.util;

import com.example.car.model.Mark;
import com.example.car.model.Model;
import com.example.car.service.ColorService;
import com.example.car.service.GenerationsService;
import com.example.car.service.MarkService;
import com.example.car.service.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;

@Slf4j
@Component
@AllArgsConstructor
public class State {
    private final MarkService markService;
    private final ModelService modelService;
    private final GenerationsService generationsService;
    private final ColorService colorService;

    public CarState createCarState() {
        Function<?, Map<?, ?>> mm = (n) -> modelService.getModelsByMark((Mark) n);
        CarState carState = new CarState();
        carState.addState("марку", (n) -> markService.findAllMap(), null);
        carState.addState("модель", mm,
                (id) -> markService.findById((Long) id));
        carState.addState("год выпуска", (n) -> generationsService.getYearsByModel((Model) n),
                null);
        carState.addState("кузов",
                (n) -> carState.getBodiesByYearByModel(generationsService), null);
        carState.addState("поколение",
                (n) -> carState.getGenerationsByImg(), null);
        carState.addState("тип двигателя",
                (n) -> carState.getGenerationsByEngine(), null);
        carState.addState("трансмиссию",
                (n) -> carState.getGenerationsByTransmission(), null);
        carState.addState("коробку передач",
                (n) -> carState.getGenerationsByGear(), null);
        carState.addState("модификацию",
                (n) -> carState.getGenerationsModification(), null);
        carState.addState("цвет",
                (n) -> colorService.findAllMap(), null);
        return carState;
    }
}
//(n) -> modelService.findAllMap()
//(n) -> modelService.getModelsByMark((Mark) n),
