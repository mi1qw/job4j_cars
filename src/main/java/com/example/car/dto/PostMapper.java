package com.example.car.dto;

import com.example.car.model.Car;
import com.example.car.model.Modification;
import com.example.car.model.Options;
import com.example.car.service.*;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Slf4j
@Mapper(componentModel = "spring")
public abstract class PostMapper {
    @Autowired
    private MarkService markService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private BodyService bodyService;
    @Autowired
    private GearboxService gearboxService;
    @Autowired
    private EngineService engineService;
    @Autowired
    private TransmissionService transmissionService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private CityService cityService;


    @BeforeMapping
    protected void before(final Car car) {
        Long id = car.getMark().getId();
        car.setMark(markService.findById(id));

        id = car.getModel().getId();
        car.setModel(modelService.findById(id));

        id = car.getBody().getId();
        car.setBody(bodyService.findById(id));

        id = car.getGearbox().getId();
        car.setGearbox(gearboxService.findById(id));

        id = car.getEngine().getId();
        car.setEngine(engineService.findById(id));

        id = car.getTransmission().getId();
        car.setTransmission(transmissionService.findById(id));

        id = car.getCity().getId();
        car.setCity(cityService.findById(id));

        id = car.getColor().getId();
        car.setColor(colorService.findById(id));
    }


    protected Map<String, List<Options>> optionsToMap(final Set<Options> options) {
        return options.stream().collect(
                Collectors.groupingBy(Options::getNameCategory));
    }

    @Mapping(target = "optionsMap", expression = "java( optionsToMap(car.getOptions()) )")
    @Mapping(source = "car.id", target = "id")
    @Mapping(source = "modification.engineDisplacement", target = "engineDisplacement")
    @Mapping(source = "modification.power", target = "power")
    public abstract PostDto carToPostDto(Car car, Modification modification);
}
