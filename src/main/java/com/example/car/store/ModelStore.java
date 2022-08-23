package com.example.car.store;

import com.example.car.model.Model;
import org.springframework.stereotype.Repository;

@Repository
public class ModelStore extends CrudPersist<Model> {

    public ModelStore() {
        super(Model.class);
    }
}
