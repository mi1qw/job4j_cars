package com.example.car.util;

import com.example.car.model.Account;
import com.example.car.model.Car;
import com.example.car.model.Mark;
import com.example.car.model.Status;
import com.example.car.web.UserSession;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@AllArgsConstructor
public class Debug {
    private final UserSession userSession;

    @PostConstruct
    public void userSessionLog() {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);
        ScheduledFuture<?> fixedRate = threadPool.scheduleAtFixedRate(() -> {

            Account account = userSession.getAccount();
            String accountStr = "account ";
            if (account != null) {
                String firstName = account.getFirstName();
                accountStr = accountStr.concat(String.valueOf(firstName));
            }

            CarState carState = userSession.getCarState();
            String carStateStr = "carState ";
            if (carState != null) {
                boolean isDone = carState.isDone();
                carStateStr = carStateStr.concat(String.valueOf(isDone));
            }

            Car newCar = userSession.getNewCar();
            String newCarStr = "newCar ";
            if (newCar != null) {
                Long id = newCar.getId();
                Status status = newCar.getStatus();
                Mark mark = newCar.getMark();
                newCarStr = newCarStr
                        .concat(String.valueOf(id))
                        .concat(mark.getName())
                        .concat(status.name());
            }

            AtomicInteger maxID = userSession.getMaxID();
            String maxIDStr = "maxID ";
            if (maxID != null) {
                maxIDStr = maxIDStr
                        .concat(String.valueOf(maxID.get()));
            }

            AtomicInteger order = userSession.getOrder();
            String orderStr = "order ";
            if (order != null) {
                orderStr = orderStr
                        .concat(String.valueOf(order.get()));
            }

            FilterForm1 filterForm = userSession.getFilterForm();
            String filterFormStr = "filterForm ";
            if (filterForm != null) {
                filterForm.getQuery();
                filterFormStr = filterFormStr
                        .concat(filterForm.getQuery());
            }
            log.info("{}  {}  {}  {}  {}  \n{}", accountStr, carStateStr, newCarStr, maxIDStr,
                    orderStr, filterFormStr);
        }, 0, 5, TimeUnit.SECONDS);
    }
}
