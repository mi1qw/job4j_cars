package com.example.car.service;

import com.example.car.model.Mark;
import com.example.car.store.MarkStore;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MarkService {
    //    @Autowired
    private final MarkStore markStore;

    private final Set<Mark> marks = new HashSet<>();
    @Getter
    private final Map<Long, Mark> marksMap = new HashMap<>();


    public MarkService(final MarkStore markStore) {
        this.markStore = markStore;
//        this.marks.addAll(findAll());
        lisTtoMap();
    }

    public List<Mark> findAll() {
//        return markStore.findAll();
        return marksMap.values().stream().toList();
    }

    public Map<Long, Mark> findAllMap() {
//        return markStore.findAll();
        return marksMap;
    }

    public Mark findById(final Long id) {
//        return markStore.findById(id);
        return marksMap.get(id);
    }

    private void lisTtoMap() {
        markStore.findAll().forEach(n -> marksMap.put(n.getId(), n));
    }
}
