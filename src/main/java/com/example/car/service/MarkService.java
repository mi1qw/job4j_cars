package com.example.car.service;

import com.example.car.model.Mark;
import com.example.car.store.MarkStore;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MarkService {
    private final MarkStore markStore;
    private final Set<Mark> marks = new HashSet<>();

    public MarkService(final MarkStore markStore) {
        this.markStore = markStore;
        this.marks.addAll(findAll());
    }

    public List<Mark> findAll() {
        return markStore.findAll();
    }
}
