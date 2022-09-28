package com.example.car.util;

import com.example.car.dto.FilterDto;
import com.example.car.model.Car;
import com.example.car.web.UserSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

@Component
@Slf4j
public class PathForm {
    //    @Autowired
    private final UserSession userSession;
    private final List<Item> list;

    public PathForm(final UserSession userSession) {
        this.userSession = userSession;
        this.list = add();
    }

    public List<Item> add() {
        List<Item> list = new ArrayList<>();
        list.add(Item.of("city", (t, f) -> f.setCity(Math.toIntExact(t)),
                (car) -> car.getCity().getId()));
        list.add(Item.of("mark", (t, f) -> f.setMark(Math.toIntExact(t)),
                (car) -> car.getMark().getId()));
        list.add(Item.of("model", (t, f) -> f.setModel(Math.toIntExact(t)),
                (car) -> car.getModel().getId()));
        list.add(Item.of("body", (t, f) -> f.setBody(Math.toIntExact(t)),
                (car) -> car.getBody().getId()));
        list.add(Item.of("engine", (t, f) -> f.setEngine(Math.toIntExact(t)),
                (car) -> car.getEngine().getId()));
        return list;
    }

    //    public void make(final List<Item> list) {
    public void make(final String nameFilter) {
        Car car = userSession.getNewCar();
        FilterDto filterDto = userSession.getFilterForm().getFilterDto();
        log.info("{}", filterDto);
        list.forEach(n -> {
            Object id = n.getterSup.apply(car);
            n.construct.accept(id, filterDto);
        });
        log.info("{}", filterDto);
    }


    @RequiredArgsConstructor(staticName = "of")
    public static class Item<T> {
        private final String name;
        private final BiConsumer<T, FilterDto> construct;
        private final Function<Car, T> getterSup;
    }
}
