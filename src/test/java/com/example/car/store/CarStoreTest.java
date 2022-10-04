package com.example.car.store;

import com.example.car.model.Car;
import com.example.car.model.Driver;
import com.example.car.model.Engine;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class CarStoreTest {
    @Autowired
    private CarStore carStore;
    @Autowired
    private EngineStore engineStore;
    @Autowired
    private DriverStore driverStore;

    @Test
    void addCar() {
        Engine engine = new Engine("engine-A");
        engineStore.add(engine);
        Car car = new Car("car-A", engine);
        carStore.add(car);
    }

//    @Test
//    void addCarWithDriver() {
//        Driver ann = driverStore.add(new Driver("Ann"));
//        Engine engine = engineStore.add(new Engine("engine-B"));
//        Car car = new Car("car-B", engine);
//        car.getDrivers().add(ann);
//        carStore.add(car);
//        assertThat(carStore.findById(car.getId()))
//                .satisfies(n -> assertThat(n.getName()).isEqualTo("car-B"))
//                .satisfies(n -> assertThat(n.getEngine().getName()).isEqualTo("engine-B"));
//    }

    @Test
    void addImages() {
        Car car = new Car();
        carStore.add(car);

        car.getImages().add("aa");
        car.getImages().add("bb");
        car = carStore.merge(car);
        car.getImages().add("cc");
        car = carStore.merge(car);

        car.getImages().remove(1);
        car.setName("AAA");
        car = carStore.merge(car);
    }

    @Test
    void addAndgetImages() {

        Car car = carStore.getCar(116L);
        log.info("car={}", car);
        carStore.deleteImageByOrder(car, 16);
        log.info("car={}", car);
    }
//    @Test
//    void addImagesSQL() {
//        Car car = new Car();
//        car = carStore.add(car);
//
//        boolean a = carStore.addImage(car, "A");
//        car.setId(0L);
//        try {
//            a = carStore.addImage(car, "B");
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//
//
//    }
}
