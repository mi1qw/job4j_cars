package com.example.car;

import com.example.car.model.Account;
import com.example.car.model.Car;
import com.example.car.util.CarState;
import com.example.car.util.FilterForm;
import com.example.car.web.UserSession;
import lombok.Getter;
import org.springframework.boot.test.context.TestConfiguration;

import java.util.concurrent.atomic.AtomicInteger;

@TestConfiguration
@Getter
public class UserTestSession {
    private Account account;
    private CarState carState;
    private Car newCar;
    private AtomicInteger maxID;
    private AtomicInteger order = new AtomicInteger();
    private FilterForm filterForm = new FilterForm();
    private FilterForm breadcrumb = new FilterForm();

    public void setUserSession(final UserSession userSession) {
        this.account = userSession.getAccount();
        this.carState = userSession.getCarState();
        this.newCar = userSession.getNewCar();
        this.maxID = userSession.getMaxID();
        this.order = userSession.getOrder();
        this.filterForm = userSession.getFilterForm();
        this.breadcrumb = userSession.getBreadcrumb();
    }
}
