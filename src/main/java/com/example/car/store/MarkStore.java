package com.example.car.store;

import com.example.car.model.Mark;
import org.springframework.stereotype.Repository;

@Repository
public class MarkStore extends CrudPersist<Mark> {

    public MarkStore() {
        super(Mark.class);
    }
}
