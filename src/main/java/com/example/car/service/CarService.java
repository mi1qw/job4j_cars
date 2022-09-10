package com.example.car.service;

import com.example.car.dto.CarMapper;
import com.example.car.dto.FileImageDto;
import com.example.car.model.Car;
import com.example.car.store.CarStore;
import com.example.car.util.State;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private final CarStore carStore;
    private final CarMapper carMapper;
    private final State state;

    public Car addCar() {
        return carStore.add(new Car());
    }

    public Car merge(final Car car) {
        LocalDateTime created = car.getCreated();
        created = created == null ? LocalDateTime.now() : created;
        car.setCreated(created);
        return carStore.merge(car);
    }

//    public Car mergeCar(final Car car) {
//        LocalDateTime created = car.getCreated();
//        created = created == null ? LocalDateTime.now() : created;
//        LocalDateTime created1 = car.getCreated();
//        return carStore.merge(car);
//    }

    public boolean addImage(final Car car, final FileImageDto imageDto) {
        return carStore.addImage(car, imageDto);
    }

    public Car deleteImageByName(final Car car, final String name) {
        return carStore.deleteImageByName(car, name);
    }

    public Car getCar(final Long id) {
        return carStore.getCar(id);
    }

    public Car reorderImg(final Car car, final String[] names) {
        return carStore.reorderImg(car.getId(), names);
    }

    public List<Car> finAll() {
        return carStore.findAll();
    }

    // TODO фильтр добавить
    public List<Car> finCarsWithEngineGearFILTR() {
        return carStore.finCarsWithEngineGearFILTR();
    }
}
