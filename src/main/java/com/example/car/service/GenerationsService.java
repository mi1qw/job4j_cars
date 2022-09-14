package com.example.car.service;

import com.example.car.model.Generations;
import com.example.car.model.Model;
import com.example.car.store.GenerationsStore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GenerationsService {
    private final GenerationsStore generationsStore;

    private final Map<Long, Model> modelsMap = new HashMap<>();

    public List<Model> findAll() {
        return modelsMap.values().stream().toList();
    }

    public Map<Long, Model> findAllMap() {
        return modelsMap;
    }

//    public Model findById(final Long id) {
//        return modelStore.findById(id);
//    }

    public Map<Long, Short> getYearsByModel(final Model model) {
        return generationsStore.getYearsByModel(model).stream()
                .collect(Collectors.toMap(Short::longValue, Function.identity(),
                        (o1, o2) -> o1, TreeMap::new));
    }

    public List<Generations> getGenerationsByYearByModel(final Short year, final Model model) {
        return generationsStore.getGenerationsByYearByModel(year, model);
    }

    public Generations findById(final Long id) {
        return generationsStore.findById(id);
    }
}
