package com.example.car.service;

import com.example.car.model.Mark;
import com.example.car.model.Model;
import com.example.car.store.MarkStore;
import com.example.car.store.ModelStore;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ModelService {
    private final ModelStore modelStore;

    private final Map<Long, Model> modelsMap = new HashMap<>();
    private final Map<Mark, List<Model>> modelsByMark;
    private final Map<Mark, List<Model>> modelsByMarkMap;
    public ModelService(final ModelStore modelStore) {
        this.modelStore = modelStore;
        modelStore.findAll().forEach(n -> modelsMap.put(n.getId(), n));
        this.modelsByMark = modelsMap.values().stream()
                .collect(Collectors.groupingBy(Model::getMark));

        Map<Mark, Map<Long, String>> collect = modelsMap.values().stream()
                .collect(Collectors.groupingBy(Model::getMark,
                        Collectors.toMap(Model::getId, Model::getName)));
    }

    public List<Model> findAll() {
        return modelsMap.values().stream().toList();
    }

    public Map<Long, Model> findAllMap() {
        return modelsMap;
    }

    public Map<Long, Model> getModelsByMark(final Mark mark) {
        return modelStore.getModelsByMark(mark);
    }

    public Model findById(final Long id) {
        return modelsMap.get(id);
    }
}
