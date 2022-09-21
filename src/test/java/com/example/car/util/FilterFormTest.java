package com.example.car.util;

import com.example.car.model.Car;
import com.example.car.model.Color;
import com.example.car.service.ColorService;
import com.example.car.store.SessionStore;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class FilterFormTest implements SessionStore {
    @Autowired
    private ColorService colorService;

    @Test
    void emptyParam() {
        FilterForm carC = new FilterForm("select c from Car c");
        List<Car> tx = tx(session ->
                session.createQuery(carC.makeQuery(), Car.class)
                        .list());
        log.info("{}", carC.getQuery());
        tx.forEach(n -> log.info("{}", n.getId()));
    }

    @Test
    void addParam() {
        Color color = colorService.findById(11L);
        FilterForm carC = new FilterForm("select c from Car c");
        carC
//                .addParam("year", 2021)
//                .addParam("color", color);
                .addParamID("color", 11);
//                .addParam("id", 8)
//                .addFromParam("odometer", 25)
//                .addBeforeParam("odometer", 60);

        List<Car> tx = tx(session -> {
                    Query<Car> query = session.createQuery(
                            carC.makeQuery(),
                            Car.class);
                    Query<Car> carQuery = carC.setParameters(query);
                    ScrollableResults<Car> scroll = carQuery.scroll(ScrollMode.SCROLL_INSENSITIVE);
                    scroll.last();
                    int rowNumber = scroll.getRowNumber() + 1;
                    scroll.close();
                    log.info("{}", rowNumber);

                    return carQuery
                            .setFirstResult(0)
                            .setMaxResults(2)
                            .list();
                }
        );
        log.info("{}", carC.getQuery());
        tx.forEach(n -> log.info("{}", n.getId()));
    }
}