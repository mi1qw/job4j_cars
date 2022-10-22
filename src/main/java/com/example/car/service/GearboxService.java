package com.example.car.service;

import com.example.car.model.Gearbox;
import com.example.car.store.GearboxStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class GearboxService {
    private final GearboxStore gearboxStore;
    private final Map<Long, Gearbox> gearboxMap = new HashMap<>();

    public GearboxService(final GearboxStore gearboxStore) {
        this.gearboxStore = gearboxStore;
        init();
    }

    public void init() {
        gearboxStore.findAll().forEach(n -> gearboxMap.put(n.getId(), n));
    }

    public List<Gearbox> findAll() {
        return gearboxMap.values().stream().toList();
    }

    public Map<Long, Gearbox> findAllMap() {
        return gearboxMap;
    }

    public Gearbox findById(final Long id) {
        return gearboxMap.get(id);
    }
}
