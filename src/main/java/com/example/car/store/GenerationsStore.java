package com.example.car.store;

import com.example.car.model.Generations;
import org.springframework.stereotype.Repository;

@Repository
public class GenerationsStore extends CrudPersist<Generations> {

    public GenerationsStore() {
        super(Generations.class);
    }
}
