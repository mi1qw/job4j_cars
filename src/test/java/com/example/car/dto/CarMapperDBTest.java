package com.example.car.dto;

import com.example.car.Cleaner;
import com.example.car.Migrator;
import com.example.car.model.Car;
import com.example.car.service.*;
import com.example.car.store.CityStore;
import com.example.car.store.ModificationStore;
import com.example.car.util.CarModfctn;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import({Migrator.class, Cleaner.class})
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarMapperDBTest {
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private CarService carService;
    @Autowired
    private CityService cityService;
    @Autowired
    private BodyService bodyService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private EngineService engineService;
    @Autowired
    private GearboxService gearboxService;
    @Autowired
    private MarkService markService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private OptionsService optionsService;
    @Autowired
    private TransmissionService transmissionService;

    @Autowired
    private CityStore cityStore;
    @Autowired
    private ModificationStore modificationStore;
    @Autowired
    private Cleaner cleaner;

    @AfterAll
    void cleanDB() {
        cleaner.clean();
    }

    @Test
    @Tag("withDB")
    void postMapper() {
        Car car = carService.getCar(3L);
        CarModfctn carModfctn = carService.findCarPost(car.getId());
        PostDto postDto = postMapper.carToPostDto(carModfctn.car(), carModfctn.modification());
        assertThat(postDto.getName()).isEqualTo("Toyota Camry VIII (XV70) Рестайлинг 2021");
        assertThat(postDto.getAccount().getLogin()).isEqualTo("vasya@gmail.com");
        assertThat(postDto.getModification().getPower()).isEqualTo((short) 249);
    }

    @Test
    void carToDto() {
        Car car = carService.getCar(3L);
        CarDto carDto = carMapper.carToDto(car);
        assertThat(carDto)
                .satisfies((n) -> assertThat(n.getOptions().size()).isEqualTo(7))
                .satisfies(n -> assertThat(n.getOdometer()).isEqualTo((short) 1))
                .satisfies(n -> assertThat(n.getYearPurchase()).isEqualTo((short) 2022))
                .satisfies(n -> assertThat(n.getCity().getId()).isEqualTo(3L))
                .satisfies(n -> assertThat(n.getPrice()).isEqualTo(new BigDecimal("45000.00")))
                .satisfies(n -> assertThat(n.getImages()).isEmpty());
    }

    @Test
    void dtoToCar() {
        CarDto carDto = CarDto.builder()
                .images("A|C|B")
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
        assertThat(car)
                .satisfies(n -> assertThat(n.getImages()).isEqualTo(List.of("A", "C", "B")))
                .satisfies(n -> assertThat(n.getOdometer()).isEqualTo((short) 200))
                .satisfies(n -> assertThat(n.getYearPurchase()).isEqualTo((short) 2000))
                .satisfies(n -> assertThat(n.getPrice()).isEqualTo(new BigDecimal("1000")))
                .satisfies(n -> assertThat(n.getDescription()).isEqualTo("description"));
    }
}
