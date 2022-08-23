package com.example.car.store;

import com.example.car.model.Body;
import org.springframework.stereotype.Repository;

@Repository
public class BodyStore extends CrudPersist<Body> {

    public BodyStore() {
        super(Body.class);
    }
}
