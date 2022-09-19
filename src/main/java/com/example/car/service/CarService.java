package com.example.car.service;

import com.example.car.dto.CarMapper;
import com.example.car.dto.FileImageDto;
import com.example.car.dto.FilterDto;
import com.example.car.model.Account;
import com.example.car.model.Car;
import com.example.car.model.Status;
import com.example.car.store.CarStore;
import com.example.car.util.State;
import com.example.car.web.UserSession;
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
    private final UserSession userSession;

    public Car addCar() {
        Account account = userSession.getAccount();
        Car car = new Car();
        car.setAccount(account);
        return carStore.add(car);
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

    public List<Car> filterForm(final FilterDto filterDto) {
        return carStore.findByFilter(filterDto);
    }

    public List<Car> findMyCar() {
        Account account = userSession.getAccount();
        return carStore.findMyCar(account);
    }

    public boolean chageStatus(final Long id, final boolean status) {
        if (status) {
            return carStore.changeStatus(id, Status.onSale);
        }
        return carStore.changeStatus(id, Status.notActive);
    }
}
