package com.example.car.store;

import com.example.car.model.City;
import org.springframework.stereotype.Repository;

@Repository
public class CityStore extends CrudPersist<City> {

    public CityStore() {
        super(City.class);
    }
}
