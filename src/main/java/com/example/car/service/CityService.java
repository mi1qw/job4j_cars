package com.example.car.service;

import com.example.car.model.City;
import com.example.car.store.CityStore;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityService {
    private final CityStore cityStore;

    private final Map<Long, City> cityMap = new HashMap<>();

    public CityService(final CityStore cityStore) {
        this.cityStore = cityStore;
        cityStore.findAll().forEach(n -> cityMap.put(n.getId(), n));
    }

    public List<City> findAll() {
        return cityMap.values().stream().toList();
    }

    public Map<Long, City> findAllMap() {
        return cityMap;
    }

    public City findById(final Long id) {
        return cityMap.get(id);
    }
}
