package com.example.car.service;

import com.example.car.dto.FileImageDto;
import com.example.car.model.Car;
import com.example.car.store.CarStore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {
    private final CarStore carStore;

    public Car addCar() {
        return carStore.add(new Car());
    }

    public Car addImages(final Car car) {
        return carStore.addImages(car);
    }

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
//    public Car findByIdWithImages(final Long id) {
//        return carStore.findByIdWithImages(id);
//    }
}
