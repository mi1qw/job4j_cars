package com.example.car.util;

import com.example.car.model.Car;
import com.example.car.service.CarService;
import com.example.car.service.MarkService;
import com.example.car.web.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
class CarStateTest {
    @Autowired
    UserSession userSession;
    @Autowired
    MarkService markService;
    @Autowired
    State state;
    @Autowired
    CarService carService;

    @Test
    void isFalse() {
        userSession.setCarState(state.createCarState());
        boolean isDone = userSession.getCarState().isDone();
        assertThat(isDone).isFalse();

    }

/*    @Test
    void getOptionsMarks() {
        userSession.setCarState(state.getCarState());
        CarState.State<Mark> state = (CarState.State<Mark>)
                userSession.getCarState().getStateList().get(0);
        List<Mark> options = state.getOptions();
        options.forEach(n -> log.info("{}", n));
        assertThat(options.size()).isNotZero();
    }*/

    @Test
    void findCarPost() {
        CarModfctn carModfctn = carService.findCarPost(20L);
    }

    @Test
    void getSteps() {
    }


    @Test
    void setStateList() {
    }

    @Test
    void setDone() {
    }

    @Test
    void setSteps() {
    }

    @Test
    void setMarkService() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void canEqual() {
    }
}