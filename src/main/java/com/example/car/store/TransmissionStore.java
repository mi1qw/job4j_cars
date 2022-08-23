package com.example.car.store;

import com.example.car.model.Transmission;
import org.springframework.stereotype.Repository;

@Repository
public class TransmissionStore extends CrudPersist<Transmission> {

    public TransmissionStore() {
        super(Transmission.class);
    }
}
