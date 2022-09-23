package com.example.car.dto;

import com.example.car.model.Car;
import com.example.car.model.Mark;
import com.example.car.service.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
@Mapper(componentModel = "spring")
public abstract class PostMapper {
    @Autowired
    private MarkService markService;
    @Autowired
    private AccountService accountService;
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
//    @Autowired
//    private ModelService  modelService;


//    public PostMapper(final MarkService markService) {
//        this.markService = markService;
//    }


    @BeforeMapping
    protected void before(final Car car) {
//        System.out.println(markService.findById(car.getMark().getId()) + "   markService");
//        System.out.println(markService + "   markService");

//        car.setDescription("kkkkkkkkkkk");

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

        // TODO аккаунт из БД тянуть
//        id = car.getAccount().getId();
//        car.setAccount(accountService.findById(id));

        id = car.getColor().getId();
        car.setColor(colorService.findById(id));
    }

    @AfterMapping
//    protected PostDto after(final @MappingTarget   postDto) {
    protected void after(final Car car) {
//        log.info("{}", "!qqqqqqqqqq");
        System.out.println("!qqqqqqqqqq");
        int a = 10;

//        System.out.println(postDto.getMark().getId());
//        postDto.setDescription("wwwwwwwww");
//        return postDto;
    }


//    работает но толку с Car
//    protected void after(final Car car) {

//    работает, но нет PostDto
//    @AfterMapping
//    protected void after() {
//        System.out.println("!qqqqqqqqqq");
//    }

    public abstract PostDto carToPostDto(Car car);
}
