package com.example.car.service;

import com.example.car.model.Mark;
import com.example.car.model.Model;
import com.example.car.store.ModelStore;
import com.example.car.web.UserSession;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ModelService {
    private final ModelStore modelStore;
    private final UserSession userSession;
    private final Map<Long, Model> modelsMap = new HashMap<>();

    private Map<Mark, List<Model>> modelsByMark;
    private Map<Long, Map<Long, String>> namesByMarkIdMap;

    public ModelService(final ModelStore modelStore, final UserSession userSession) {
        this.modelStore = modelStore;
        this.userSession = userSession;
        modelStore.findAll().forEach(n -> modelsMap.put(n.getId(), n));
    }

    @PostConstruct
    public void init() {
        this.namesByMarkIdMap = modelsMap.values().stream()
                .collect(Collectors.groupingBy(
                        n -> n.getMark().getId(),
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

    public Map<Long, String> getModelNamesByMarkId(final Integer id) {
        return id != null ? namesByMarkIdMap.get((long) id) : null;
    }

    public Model findById(final Long id) {
        return modelsMap.get(id);
    }
}
