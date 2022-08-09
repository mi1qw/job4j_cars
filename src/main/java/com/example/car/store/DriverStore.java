package com.example.car.store;

import com.example.car.model.Driver;
import org.springframework.stereotype.Repository;

@Repository
public class DriverStore extends CrudPersist<Driver> {

    public DriverStore() {
        super(Driver.class);
    }
}
