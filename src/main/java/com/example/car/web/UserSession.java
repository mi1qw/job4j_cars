package com.example.car.web;

import com.example.car.model.Account;
import com.example.car.model.Car;
import com.example.car.util.CarState;
import com.example.car.util.FilterForm;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@SessionScope
@Data
public class UserSession {
    private Account account;
    private CarState carState;
    private Car newCar;
    private AtomicInteger maxID;
    private AtomicInteger order = new AtomicInteger();
    private FilterForm filterForm = new FilterForm();
    private FilterForm breadcrumb = new FilterForm();
}
