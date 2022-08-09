package com.example.car.store;

import com.example.car.model.Engine;
import org.springframework.stereotype.Repository;

@Repository
public class EngineStore extends CrudPersist<Engine> {

    public EngineStore() {
        super(Engine.class);
    }
}
