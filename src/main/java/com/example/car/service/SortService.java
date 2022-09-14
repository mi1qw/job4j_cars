package com.example.car.service;

import com.example.car.model.Sort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class SortService {
    private final Map<Long, Sort> sortMap = new HashMap<>();

    public SortService() {
        this.sortMap.putAll(Map.of(
                1L, Sort.of(1L, "Сначала дешёвые", " ORDER BY c.price ASC"),
                2L, Sort.of(2L, "Сначала дорогие", " ORDER BY c.price DESC"),
                3L, Sort.of(3L, "Сначала новые", " ORDER BY c.created DESC")
        ));
    }

    public Map<Long, Sort> findAllMap() {
        return sortMap;
    }
}
