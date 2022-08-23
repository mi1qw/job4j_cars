package com.example.car.store;

import com.example.car.model.Modification;
import org.springframework.stereotype.Repository;

@Repository
public class ModificationStore extends CrudPersist<Modification> {

    public ModificationStore() {
        super(Modification.class);
    }
}
