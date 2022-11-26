package com.example.car.store;

import com.example.car.model.Color;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ColorStoreTest implements SessionStore {
    @Autowired
    private ColorStore store;
    private static Color color;

    @Test
    @Order(1)
    void add() {
        int sizeBefore = store.findAll().size();
        color = new Color("goldBlueRed", "goldBlueRed");
        store.add(color);
        assertThat(store.findAll()).asList().hasSize(1 + sizeBefore);
    }

    @Test
    @Order(2)
    void replace() {
        color.setColor("white");
        store.replace(color.getId(), color);
        assertThat(store.findAll().get(0).getColor()).isEqualTo("white");
    }

    @Test
    @Order(3)
    void findById() {
        assertThat(store.findById(color.getId())).isEqualTo(color);
    }

    @Test
    @Order(4)
    void findByName() {
        assertThat(store.findByName(color.getName()).get(0)).isEqualTo(color);
    }

    @Test
    @Order(5)
    void findAll() {
        assertThat(store.findAll()).asList().hasSize(1);
        store.add(new Color("gold", "gold"));
        assertThat(store.findAll()).asList().hasSize(2);
    }

    @Test
    @Order(6)
    void delete() {
        store.delete(color.getId());
        assertThat(store.findAll()).asList().isNotEmpty();
        store.findAll().forEach(n -> store.delete(n.getId()));
        assertThat(store.findAll()).asList().isEmpty();
    }
}
