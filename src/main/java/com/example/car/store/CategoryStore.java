package com.example.car.store;

import com.example.car.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryStore extends CrudPersist<Category> {

    public CategoryStore() {
        super(Category.class);
    }
}
