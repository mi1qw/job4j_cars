package com.example.car.store;

import com.example.car.model.Car;
import org.springframework.stereotype.Repository;

@Repository
public class CarStore extends CrudPersist<Car> {

    public CarStore() {
        super(Car.class);
    }
}
