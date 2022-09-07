package com.example.car.web;

import com.example.car.model.Car;
import com.example.car.util.CarState;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@SessionScope
@Data
public class UserSession {
    private CarState carState;
    private Car newCar;
    private AtomicInteger maxID;
    private AtomicInteger order = new AtomicInteger();
    // TODO создавать при создании сессии
}
