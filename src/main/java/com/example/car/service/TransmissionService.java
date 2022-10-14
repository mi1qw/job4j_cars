package com.example.car.service;

import com.example.car.model.Transmission;
import com.example.car.store.TransmissionStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TransmissionService {
    private final TransmissionStore transmissionStore;
    private final Map<Long, Transmission> transmissionMap = new HashMap<>();

    public TransmissionService(final TransmissionStore transmissionStore) {
        this.transmissionStore = transmissionStore;
        transmissionStore.findAll().forEach(n -> transmissionMap.put(n.getId(), n));
    }

    public List<Transmission> findAll() {
        return transmissionMap.values().stream().toList();
    }

    public Map<Long, Transmission> findAllMap() {
        return transmissionMap;
    }

    public Transmission findById(final Long id) {
        return transmissionMap.get(id);
    }
}
