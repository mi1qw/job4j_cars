package com.example.car.util;

import static org.junit.jupiter.api.Assertions.*;

import com.example.car.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Slf4j
class ImageUtilTest {
    @Test
    void testFindMaxID() {
        Car car = new Car();
        car.setImages(
                List.of(
                        "103-7-logoSkoda.png",
                        "103-8-logoSkoda.png",
                        "103-9-logoSkoda.png",
                        "103-10-logoSkoda.png",
                        "103-11-logoSkoda.png",
                        "103-12-logoSkoda.png",
                        "103-13-logoSkoda.png"));

        log.info("{}", ImageUtil.findMaxID(car));
    }

    @Test
    void testFindMaxIDEmpty() {
        Car car = new Car();
        car.setImages(
                List.of());

        log.info("{}", ImageUtil.findMaxID(car));
    }
}