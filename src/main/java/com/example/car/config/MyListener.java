package com.example.car.config;

import com.example.car.model.Account;
import com.example.car.model.Car;
import com.example.car.model.Status;
import com.example.car.util.CarState;
import com.example.car.util.FilterForm;
import com.example.car.web.UserSession;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@WebListener
@Slf4j
public class MyListener extends RequestContextListener {
    @Autowired
    private UserSession userSession;

    @Override
    public void requestInitialized(final ServletRequestEvent requestEvent) {
        super.requestInitialized(requestEvent);
        userSessionLog();
    }

    public void userSessionLog() {
        try {
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
                String markID = newCar.getMark() != null
                        ? String.valueOf(newCar.getMark().getId())
                        : "";
                newCarStr = newCarStr
                        .concat(String.valueOf(id)).concat(", ")
                        .concat(markID).concat(", ")
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

            FilterForm filterForm = userSession.getFilterForm();
            String filterFormStr = "filterForm ";
            if (filterForm != null && filterForm.getQuery() != null) {
                filterFormStr = filterFormStr
                        .concat(filterForm.getQuery());
            }
            log.info("{}   {}   {}   {}   {}   \n{}", accountStr, carStateStr, newCarStr, maxIDStr,
                    orderStr, filterFormStr);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }
}
