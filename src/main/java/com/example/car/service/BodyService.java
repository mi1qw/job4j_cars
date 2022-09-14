package com.example.car.service;

import com.example.car.model.Body;
import com.example.car.store.BodyStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BodyService {
    private final BodyStore bodyStore;
    private Map<Long, Body> bodyMap = new HashMap<>();
    private List<Body> bodyList = new ArrayList<>();

    public BodyService(final BodyStore bodyStore) {
        this.bodyStore = bodyStore;
        bodyStore.findAll().forEach(n -> bodyMap.put(n.getId(), n));
        bodyList.addAll(bodyStore.findAll());
    }

    public List<Body> findAll() {
        return bodyList;
    }
}
