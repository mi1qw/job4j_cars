package com.example.car.model;

import static org.junit.jupiter.api.Assertions.*;

import com.example.car.store.ColorStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ColorTest {
    @Autowired
    private ColorStore colorStore;

    @Test
    void getName() {
        colorStore.add(new Color("black", "0"));
    }
}