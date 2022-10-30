package com.example.car.dto;

import com.example.car.model.Car;
import com.example.car.service.CarService;
import com.example.car.service.CityService;
import com.example.car.util.CarModfctn;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class CarMapperTest {
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private CarService carService;
    @Autowired
    private CityService cityService;

    @Test
    void carToDto() {
        Car car = new Car();
        car.setOdometer((short) 100);
        car.setYearPurchase((short) 2000);
        car.setDescription("dddd");
        car.setPrice(BigDecimal.valueOf(1000L));
        car.setYear((short) 2001);
        car.setImages(List.of("A", "B"));
        car.setCity(cityService.findById(1L));
        car.setImages(List.of("A", "B"));
        CarDto carDto = carMapper.carToDto(car);
        log.info("{}", carDto);
        assertThat(carDto.getOdometer()).isEqualTo(((short) 100));

    }

    @Test
    void dtoToCar() {
        CarDto carDto = CarDto.builder()
                .images("A|C|B")
                .odometer((short) 200)
                .yearPurchase((short) 2000)
                .description("description")
                .price(BigDecimal.valueOf(1000L))
                .build();
        Car car = carMapper.dtoToCar(carDto);
        assertThat(car.getImages()).isEqualTo(List.of("A", "C", "B"));
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
        CarDto carDto = CarDto.builder()
                .images("A|C|B")
                .odometer((short) 200)
                .yearPurchase((short) 2000)
                .description("description")
                .price(BigDecimal.valueOf(1000L))
                .build();
        carMapper.updateCar(carDto, car);
        assertThat(car.getImages()).isEqualTo(List.of("A", "C", "B"));
    }

    @Test
    void postMapper() {
        Car car = carService.getCar(3L);
        CarModfctn carModfctn = carService.findCarPost(car.getId());
        PostDto postDto = postMapper.carToPostDto(carModfctn.car(), carModfctn.modification());
        assertThat(postDto.getName()).isNotNull();
        assertThat(postDto.getAccount()).isNotNull();
        assertThat(postDto.getModification().getPower()).isNotNull();
    }
}
