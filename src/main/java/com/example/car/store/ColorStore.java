package com.example.car.store;

import com.example.car.model.Color;
import org.springframework.stereotype.Repository;

@Repository
public class ColorStore extends CrudPersist<Color> {

    public ColorStore() {
        super(Color.class);
    }
}
