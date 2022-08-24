package com.example.car.service;

import com.example.car.config.StorageProperties;
import com.example.car.model.Color;
import com.example.car.model.Mark;
import com.example.car.model.Model;
import com.example.car.store.ColorStore;
import com.example.car.store.ModelStore;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ColorService {
    private final ColorStore colorStore;

    private final Map<Long, Color> colorsMap = new HashMap<>();

    public ColorService(final ColorStore colorStore) {
        this.colorStore = colorStore;
        colorStore.findAll().forEach(n -> colorsMap.put(n.getId(), n));
    }

    public List<Color> findAll() {
        return colorsMap.values().stream().toList();
    }

    public Map<Long, Color> findAllMap() {
        return colorsMap;
    }

    public Color findById(final Long id) {
        return colorsMap.get(id);
    }
}
