package com.example.car.service;

import com.example.car.config.PostsConfig;
import com.example.car.dto.CarMapper;
import com.example.car.dto.FileImageDto;
import com.example.car.dto.FilterDto;
import com.example.car.model.*;
import com.example.car.service.dto.PaginationDto;
import com.example.car.store.CarStore;
import com.example.car.util.CarModfctn;
import com.example.car.web.Pagination;
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
    private final GearboxService gearboxService;
    private final TransmissionService transmissionService;
    private final EngineService engineService;
    private final CityService cityService;
    private final PostsConfig postsConfig;

    public Car merge(final Car car) {
        LocalDateTime created = car.getCreated();
        created = created == null ? LocalDateTime.now() : created;
        car.setCreated(created);
        return carStore.merge(car);
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

    // только в тестах, скорее всегда удалить
    public List<Car> finAll() {
        return carStore.findAll();
    }


    /**
     * выборка согласно фильтру.
     * А не быстрее ли выбирать с Join в самой БД, без использования "кэша" в java
     *
     * @param filterDto  filterDto
     * @param pagination pagination
     * @return cars
     */
    public PaginationDto filterForm(final FilterDto filterDto, final Pagination pagination) {
        PaginationDto paginationDto = carStore.findByFilter(filterDto, pagination);
        paginationDto.cars().forEach(n -> {
            Gearbox gbx = n.getGearbox();
            Gearbox gearbox = gearboxService.findById(gbx.getId());
            n.setGearbox(gearbox);
            n.setTransmission(transmissionService.findById(n.getTransmission().getId()));
            n.setEngine(engineService.findById(n.getEngine().getId()));
            n.setCity(cityService.findById(n.getCity().getId()));
        });
        return paginationDto;
    }

    public List<Car> findMyCar() {
        Account account = userSession.getAccount();
        return carStore.findMyCar(account);
    }

    public Car createCarAccount() {
        Account account = userSession.getAccount();
        return carStore.createAccountCar(account);
    }

    public boolean chageStatus(final Long id, final boolean status) {
        if (status) {
            return carStore.changeStatus(id, Status.onSale);
        }
        return carStore.changeStatus(id, Status.notActive);
    }

    public boolean deleteCar(final Long id) {
        return carStore.deleteCar(id);
    }

    public CarModfctn findCarPost(final Long id) {
        return carStore.findCarPost(id);
    }
}
