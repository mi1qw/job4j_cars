package com.example.car.util;

import com.example.car.service.ColorService;
import com.example.car.service.GenerationsService;
import com.example.car.service.MarkService;
import com.example.car.service.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class State {
    private final MarkService markService;
    private final ModelService modelService;
    private final GenerationsService generationsService;
    private final ColorService colorService;

    public CarState createCarState() {
        CarState carState = new CarState();
        carState.addState("марку",
                () -> carState.getMarks(markService));
        carState.addState("модель",
                () -> carState.getModelsByMark(modelService));
        carState.addState("год выпуска",
                () -> carState.getGenerationsByYear(generationsService));
        carState.addState("кузов",
                () -> carState.getBodiesByYearByModel(generationsService));
        carState.addState("поколение", carState::getGenerationsByImg);
        carState.addState("тип двигателя", carState::getGenerationsByEngine);
        carState.addState("трансмиссию", carState::getGenerationsByTransmission);
        carState.addState("коробку передач", carState::getGenerationsByGear);
        carState.addState("модификацию", carState::getGenerationsModification);
        carState.addState("цвет", colorService::findAllMap);
        return carState;
    }
}
