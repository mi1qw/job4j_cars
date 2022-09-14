package com.example.car.service;

import com.example.car.model.Body;
import com.example.car.store.BodyStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BodyService {
    private final BodyStore bodyStore;
    private final Map<Long, Body> bodyMap = new HashMap<>();

    public BodyService(final BodyStore bodyStore) {
        this.bodyStore = bodyStore;
        bodyStore.findAll().forEach(n -> bodyMap.put(n.getId(), n));
            }

    public List<Body> findAll() {
        return bodyMap.values().stream().toList();
    }

    public Map<Long, Body> findAllMap() {
        return bodyMap;
    }
}
