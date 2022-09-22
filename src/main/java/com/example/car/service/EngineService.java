package com.example.car.service;

import com.example.car.model.Engine;
import com.example.car.model.Gearbox;
import com.example.car.store.EngineStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class EngineService {
    private final EngineStore engineStore;
    private final Map<Long, Engine> engineMap = new HashMap<>();

    public EngineService(final EngineStore engineStore) {
        this.engineStore = engineStore;
        engineStore.findAll().forEach(n -> engineMap.put(n.getId(), n));
    }

    public List<Engine> findAll() {
        return engineMap.values().stream().toList();
    }

    public Map<Long, Engine> findAllMap() {
        return engineMap;
    }

    public Engine findById(final Long id) {
        return engineMap.get(id);
    }
}
