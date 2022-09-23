package com.example.car.dto;

import com.example.car.model.Car;
import com.example.car.service.AccountService;
import com.example.car.service.MarkService;
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

//    public PostMapper(final MarkService markService) {
//        this.markService = markService;
//    }


    @BeforeMapping
    protected void before(final Car car) {
        System.out.println(markService.findById(car.getMark().getId()) + "   markService");
        System.out.println(markService + "   markService");

        car.setDescription("kkkkkkkkkkk");

        // System.out.println(car.getId() + "  car.getId()");
        // I would call my entity manager's flush() method here to make sure my entity
        // is populated with the right @Version before I let it map into the DTO
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
