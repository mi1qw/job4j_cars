package com.example.car.util;

import com.example.car.model.*;
import com.example.car.service.ColorService;
import com.example.car.service.GenerationsService;
import com.example.car.service.MarkService;
import com.example.car.service.ModelService;
import com.example.car.web.UserSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
@AllArgsConstructor
public class State {
    private final MarkService markService;
    private final ModelService modelService;
    private final GenerationsService generationsService;
    private final ColorService colorService;
    private final UserSession userSession;

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

    public Car getResultCar() {
        CarState carState = userSession.getCarState();
        CarState.GenMod genMod = (CarState.GenMod) carState
                .getStepList()
                .get(8)
                .getValue();
        log.info("{}", genMod);

        int[] filtered = {0};
        Generations generations = carState.getGenerations().stream()
                .filter(n -> n.getId().equals(genMod.id()))
                .peek(n -> ++filtered[0])
                .findAny()
                .orElseThrow(IllegalStateException::new);
        if (filtered[0] > 1) {
            log.error("filtered List > 1");
        }

        Car newCar = userSession.getNewCar();
        List<CarState.State<?, ?>> stepList = carState.getStepList();
        List<Boolean> checkList = new ArrayList<>();


        Mark mark = (Mark) stepList.get(0).getValue();
        newCar.setMark(mark);
        checkList.add(generations.getModification().getId().getMarkId().equals(mark));

        Model model = (Model) stepList.get(1).getValue();
        newCar.setModel(model);
        checkList.add(generations.getModel().getId().equals(model.getId()));

        Short year = (Short) stepList.get(2).getValue();
        newCar.setYear(year);
        checkList.add(generations.getYear().equals(year));

        Body body = (Body) stepList.get(3).getValue();
        newCar.setBody(body);
        checkList.add(generations.getBody().equals(body));

        String generationName = ((CarState.Img) stepList.get(4).getValue()).name();
        checkList.add(generations.getName().equals(generationName));

        Engine engine = (Engine) stepList.get(5).getValue();
        newCar.setEngine(engine);
        checkList.add(generations.getEngine().equals(engine));

        Transmission transmission = (Transmission) stepList.get(6).getValue();
        newCar.setTransmission(transmission);
        checkList.add(generations.getTransmission().equals(transmission));

        Gearbox gearbox = (Gearbox) stepList.get(7).getValue();
        newCar.setGearbox(gearbox);
        checkList.add(generations.getGearbox().equals(gearbox));

        CarState.GenMod modification = (CarState.GenMod) stepList.get(8).getValue();
        newCar.setModification(modification.name());
        checkList.add(generations.getModification().getId()
                .getNameId().equals(modification.name()));

        boolean allMatch = checkList.stream().allMatch(n -> n);
        if (!allMatch) {
            log.error("{}", "allMatch");
        }

        newCar.setGenerations(generations);

        Color color = (Color) stepList.get(9).getValue();
        newCar.setColor(color);

        newCar.setName(mark.getName() + " "
                       + model.getName() + " "
                       + generationName + " "
                       + year.toString());

        return newCar;
    }

    public CarState fillList(final Car car) {
        CarState carState = createCarState();
        userSession.setCarState(carState);
        Long generationID = car.getGenerations().getId();
        Generations generation;

        List<CarState.State<?, ?>> stepList = carState.getStepList();
        CarState.State<?, ?> step = stepList.get(0);
//        step.setValue(generation.getModification().getId().getMarkId());
//        step.setStatus(true);
        step.makeOptions();

//        for (int i = 0; i < stepList.size(); i++) {
//            makeStep(1, i);
//        }

//        Mark mark = generation.getModification().getId().getMarkId();

        Mark mark = car.getMark();
        makeStep(mark.getId(), 0);

        Model model = car.getModel();
        makeStep(model.getId(), 1);

        Short year = car.getYear();
        makeStep(year, 2);

        Body body = car.getBody();
        makeStep(body.getId(), 3);

        generation = carState.getGenerations().stream()
                .filter(n -> n.getId().equals(generationID))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
        // TODO  из базы generations findById  имя поколения, а можно ведь напрямую сохранить
//        Generations gen = generationsService.findById(car.getGenerations().getId());
//        String genName = car.getGenerations().getName();
        String genName = generation.getName();
        Collection<CarState.Img> collection = (Collection<CarState.Img>) stepList
                .get(4).getOptions().values();
        Long id = collection.stream()
                .filter(n -> n.name().equals(genName))
                .findFirst().orElseThrow(IllegalStateException::new)
                .id();
        makeStep(id, 4);

        Engine engine = car.getEngine();
        makeStep(engine.getId(), 5);

        Transmission transmission = car.getTransmission();
        makeStep(transmission.getId(), 6);

        Gearbox gearbox = car.getGearbox();
        makeStep(gearbox.getId(), 7);

        // TODO same
        String modification = car.getModification();
        Collection<CarState.GenMod> genMods = (Collection<CarState.GenMod>) stepList
                .get(8).getOptions().values();
        id = genMods.stream()
                .filter(n -> n.name().equals(modification))
                .findFirst().orElseThrow(IllegalStateException::new)
                .id();
        makeStep(id, 8);


        Color color = car.getColor();
        makeStep(color.getId(), 9);

        return carState;
    }

    public void makeStep(final long id, final int stateID) {
        CarState state = userSession.getCarState();
        CarState.State<?, ?> step = state.getStepList().get(stateID);
        Object optionByID = step.getOptionByID(id);
        step.setValue(optionByID);

        step.setPrevGenerations(state.getGenerations());

        if (stateID + 1 < state.getStepList().size()) {
            CarState.State<?, ?> stepNext = state.getStepList().get(stateID + 1);
            stepNext.setPrevGenerations(state.getGenerations());
            Map<Long, ?> options = stepNext.makeOptions();
            if (options.size() == 0) {
                log.error(step.getName() + "  options.size() ==0");
            }
        }
    }

    public void makeSteps(final long id, final int stateID) {
        CarState state = userSession.getCarState();
        CarState.State<?, ?> step = state.getStepList().get(stateID);
        Object optionByID = step.getOptionByID(id);
        step.setValue(optionByID);

        step.setPrevGenerations(state.getGenerations());

        int step1 = stateID;
        CarState.State<?, ?> stepNext;

        while (step1 + 1 < state.getStepList().size()) {
            ++step1;
            stepNext = state.getStepList().get(step1);
            stepNext.setPrevGenerations(state.getGenerations());
            Map<Long, ?> options = stepNext.makeOptions();
            if (options.size() > 1) {
                break;
            }
            if (options.size() == 0) {
                log.error(step.getName() + "  options.size() ==0");
                break;
            }
            optionByID = options.values().iterator().next();
            stepNext.setValue(optionByID);
            stepNext.setStatus(true);
        }
    }
}
