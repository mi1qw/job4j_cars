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
        CarState state = new CarState();
        state.addStep("марку",
                () -> state.getMarks(markService));
        state.addStep("модель",
                () -> state.getModelsByMark(modelService));
        state.addStep("год выпуска",
                () -> state.getGenerationsByYear(generationsService));
        state.addStep("кузов",
                () -> state.getBodiesByYearByModel(generationsService));
        state.addStep("поколение", state::getGenerationsByImg);
        state.addStep("тип двигателя", state::getGenerationsByEngine);
        state.addStep("трансмиссию", state::getGenerationsByTransmission);
        state.addStep("коробку передач", state::getGenerationsByGear);
        state.addStep("модификацию", state::getGenerationsModification);
        state.addStep("цвет", colorService::findAllMap);
        return state;
    }
}
