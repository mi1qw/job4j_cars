package com.example.car.store;

import com.example.car.model.Model;
import com.example.car.service.GenerationsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class GenerationsStoreTest {
    @Autowired
    private GenerationsStore generationsStore;
    @Autowired
    private GenerationsService generationsService;
    @Autowired
    private ModelStore modelStore;
    @Test
    void getYearsByModel() {
        Model camry = modelStore.findByName("Camry").get(0);
        List<Short> years = generationsStore.getYearsByModel(camry);
        assertThat(years).isNotEmpty();
        System.out.println(years);
    }

    // TODO поправить
    @Test
    void getYearsByModelSorted() {
        Model camry = modelStore.findByName("Camry").get(0);
        Map<Long, Short> years = generationsService.getYearsByModel(camry);
        assertThat(years).isNotEmpty();
        System.out.println(years);
    }
}