package com.example.car.web;

import com.example.car.model.Car;
import com.example.car.util.CarState;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@SessionScope
@Data
public class UserSession {
    private CarState carState;
    private Car newCar;
    private AtomicInteger maxID;
    private AtomicInteger order = new AtomicInteger();
//    private Map<Integer, String> images;
    // TODO создавать при создании сессии
//    private TabOrder tabOrder = new TabOrder();
}
