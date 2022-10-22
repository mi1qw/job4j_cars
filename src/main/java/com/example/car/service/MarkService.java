package com.example.car.service;

import com.example.car.model.Mark;
import com.example.car.store.MarkStore;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MarkService {
    private final MarkStore markStore;
    @Getter
    private final Map<Long, Mark> marksMap = new HashMap<>();

    public MarkService(final MarkStore markStore) {
        this.markStore = markStore;
        init();
    }

    public void init() {
        markStore.findAll().forEach(n -> marksMap.put(n.getId(), n));
    }

    public List<Mark> findAll() {
        return marksMap.values().stream().toList();
    }

    public Map<Long, Mark> findAllMap() {
        return marksMap;
    }

    public Mark findById(final Long id) {
        return marksMap.get(id);
    }
}
