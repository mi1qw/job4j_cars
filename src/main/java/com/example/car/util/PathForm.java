package com.example.car.util;

import com.example.car.dto.FilterDto;
import com.example.car.model.Car;
import com.example.car.web.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

@Component
@Slf4j
public class PathForm {
    private final UserSession userSession;
    private final List<Item> list = new ArrayList<>();


    public PathForm(final UserSession userSession) {
        this.userSession = userSession;
        mapFields();
    }

    public List<Item> mapFields() {
        list.add(new Item<>("city", (t, f) -> f.setCity(t), (car) -> car.getCity().getId()));
        list.add(new Item<>("mark", (t, f) -> f.setMark(t), (car) -> car.getMark().getId()));
        list.add(new Item<>("model", (t, f) -> f.setModel(t), (car) -> car.getModel().getId()));
        list.add(new Item<>("body", (t, f) -> f.setBody(t), (car) -> car.getBody().getId()));
        list.add(new Item<>("engine", (t, f) -> f.setEngine(t), (car) -> car.getEngine().getId()));
        return list;
    }

    public FilterDto carToFilterDto(final Car car) {
        FilterDto filterDto = userSession.getFilterForm().getFilterDto().clone();

        log.info("{}", filterDto);
        list.forEach(n -> {
            Object id = n.getterSup.apply(car);
            n.construct.accept(id, filterDto);
        });
        log.info("{}", filterDto);
        return filterDto;
    }

    public void makeBreadcrumb() {
    }

    private record Item<T>(String name,
                           BiConsumer<T, FilterDto> construct,
                           Function<Car, T> getterSup) {
    }
}
