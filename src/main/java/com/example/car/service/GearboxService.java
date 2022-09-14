package com.example.car.service;

import com.example.car.model.Gearbox;
import com.example.car.store.GearboxStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GearboxService {
    private final GearboxStore gearboxStore;
    private List<Gearbox> gearList = new ArrayList<>();

    public GearboxService(final GearboxStore gearboxStore) {
        this.gearboxStore = gearboxStore;
        gearList.addAll(gearboxStore.findAll());
    }

    public List<Gearbox> findAll() {
        return gearList;
    }
}
