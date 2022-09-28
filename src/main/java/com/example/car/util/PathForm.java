package com.example.car.util;

import com.example.car.dto.FilterDto;
import com.example.car.model.Car;
import com.example.car.web.UserSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
@Slf4j
public class PathForm {
    @Autowired
    private UserSession userSession;
//    private List<Item> list = new ArrayList<>();

    //private
    public void add(final Item item) {
        List<Item> list = new ArrayList<>();
        list.add(item);
        FilterDto filter = new FilterDto();

        FilterForm filterForm = userSession.getFilterForm();
        FilterDto filterDto = filterForm.getFilterDto();
        Item<?> mark = Item.of("mark", (t, f) -> f.setMark(Math.toIntExact(t)),
                (car) -> car.getMark().getId());
        list.add(mark);
        list.add(Item.of("model", (t, f) -> f.setModel(Math.toIntExact(t)),
                (car) -> car.getModel().getId()));


    }

    public void make(final List<Item> list) {
        FilterDto filterDto = userSession.getFilterForm().getFilterDto();
        list.forEach(n -> {
            Object id = n.getterSup.apply(filterDto);
            n.construct.accept(id, filterDto);
        });
    }

    protected static class Itm {

    }

    @RequiredArgsConstructor(staticName = "of")
    protected static class Item<T> extends Itm {
        private final String name;
        private final BiConsumer<T, FilterDto> construct;
        private final Function<Car, T> getterSup;
    }
}
