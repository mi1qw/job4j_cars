package com.example.car.util;

import com.example.car.model.Car;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ImageUtilTest {
    @Test
    void testFindMaxID() {
        Car car = new Car();
        car.setImages(
                List.of(
                        "103-7-logoSkoda.png",
                        "103-8-logoSkoda.png",
                        "103-9-logoSkoda.png",
                        "103-15-logoSkoda.png",
                        "103-11-logoSkoda.png",
                        "103-12-logoSkoda.png"));
        assertThat(ImageUtil.findImageMaxID(car)).isEqualTo(15);
    }

    @Test
    void testFindMaxIDEmpty() {
        Car car = new Car();
        car.setImages(List.of());
        assertThat(ImageUtil.findImageMaxID(car)).isEqualTo(-1);
    }
}
