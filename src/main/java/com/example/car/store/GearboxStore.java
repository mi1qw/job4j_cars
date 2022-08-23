package com.example.car.store;

import com.example.car.model.Gearbox;
import org.springframework.stereotype.Repository;

@Repository
public class GearboxStore extends CrudPersist<Gearbox> {

    public GearboxStore() {
        super(Gearbox.class);
    }
}
