package com.example.car.util;

import com.example.car.model.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class FilterForm {
    private Mark mark;
    private Model model;

    // TODO from to
    private Short year;
    // TODO from to
    private int odometer;
    // TODO from to
    private short engineDisplacement;
    // TODO from to
    private BigDecimal price;


    private Body body;
    private Gearbox gearbox;
    private Engine engine;
    private Transmission transmission;

    private String query;
    private List<FilterFormIn> params = new ArrayList<>();

    public FilterForm(final String query) {
        this.query = query;
    }

    public FilterForm addParam(final String name, final Object value) {
        params.add(ElementForm.of(name, value));
        return this;
    }

    public String makeQuery() {
        if (params.isEmpty()) {
            return query;
        }
        this.query = query
                .concat(" where")
                .concat(params.get(0).getQuery());
        if (params.size() == 1) {
            return query;
        }
        for (int i = 1; i < params.size(); i++) {
            this.query = query
                    .concat(" and")
                    .concat(params.get(i).getQuery());
        }
        return query;
    }

    public Query<Car> setParameters(final Query<Car> query) {
        if (!params.isEmpty()) {
            params.forEach(n -> n.setParameter(query));
        }
        return query;
    }

    public FilterForm addFromParam(final String name, final Object from) {
        params.add(new ElementForm<>(name, from) {
            @Override
            public String getQuery() {
                return " c.".concat(name).concat(" > " + from);
            }

            @Override
            public Query<Car> setParameter(final Query<Car> query) {
                return query;
            }
        });
        return this;
    }

    public FilterForm addBeforeParam(final String name, final Object before) {
        params.add(new ElementForm<>(name, before) {
            @Override
            public String getQuery() {
                return " c.".concat(name).concat(" < " + before);
            }

            @Override
            public Query<Car> setParameter(final Query<Car> query) {
                return query;
            }
        });
        return this;
    }


    @RequiredArgsConstructor(staticName = "of")
    private static class ElementForm<T> implements FilterFormIn<Car> {
        private final String name;
        private final T value;

        @Override
        public String getQuery() {
            return " c.".concat(name).concat("=:").concat(name);
        }

        @Override
        public Query<Car> setParameter(final Query<Car> query) {
            return query.setParameter(name, value);
        }
    }
}

interface FilterFormIn<R> {
    String getQuery();

    Query<R> setParameter(Query<R> query);
}