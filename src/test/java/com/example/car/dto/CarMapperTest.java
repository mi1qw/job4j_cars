package com.example.car.dto;

import static org.junit.jupiter.api.Assertions.*;

import com.example.car.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.util.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
class CarMapperTest {
    @Autowired
    CarMapper carMapper;

    @Test
    void carToDto() {
        Car car = new Car();
        car.setOdometer((short) 100);
        car.setYearPurchase((short) 2000);
        car.setDescription("dddd");
        car.setPrice(BigDecimal.valueOf(1000L));
        car.setYear((short) 2001);
        car.setImages(List.of("A", "B"));
        CarDto carDto = carMapper.carToDto(car);
        log.info("{}", carDto);
    }

    @Test
    void dtoToCar() {
        Car car = new Car();
        car.setOdometer((short) 0);
        car.setYearPurchase((short) 1900);
        car.setDescription("aaa");
        car.setPrice(BigDecimal.valueOf(10L));
        car.setYear((short) 2001);
        car.setImages(List.of("A", "B"));

        CarDto carDto = CarDto.builder()
                .images("A|C|B")
                .odometer((short) 200)
                .yearPurchase((short) 2000)
                .description("description")
                .price(BigDecimal.valueOf(1000L))
                .build();
        carMapper.dtoToCar(carDto);
        log.info("{}", car);
    }

    @Test
    void dtoUpdateCar() {
        Car car = new Car();
        car.setOdometer((short) 0);
        car.setYearPurchase((short) 1900);
        car.setDescription("aaa");
        car.setPrice(BigDecimal.valueOf(10L));
        car.setYear((short) 2001);
        car.setImages(List.of("A", "B"));

        log.info("{}", car);

        CarDto carDto = CarDto.builder()
                .images("A|C|B")
                .odometer((short) 200)
                .yearPurchase((short) 2000)
                .description("description")
                .price(BigDecimal.valueOf(1000L))
                .build();
        carMapper.updateCar(carDto, car);
        log.info("{}", car);
    }
}