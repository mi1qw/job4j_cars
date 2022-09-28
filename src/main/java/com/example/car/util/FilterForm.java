package com.example.car.util;

import com.example.car.dto.FilterDto;
import com.example.car.model.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * FilterForm for main paige.
 * По умолчанию только сортировка "Сначала новые"=3.
 */
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

    private FilterDto filterDto;
    private String baseQuery;
    private String query;
    private List<FilterFormIn> params = new ArrayList<>();
//    private Map<String, Field> fieldMap = new HashMap<>();

    public FilterForm() {
        // TODO  FilterDto можно хранить в бд и подставлять при создании сессии
        this.baseQuery = "select c from Car c";
//        this.baseQuery = "from Car c join fetch c.gearbox "
//                         + "join fetch c.transmission";

        this.filterDto = FilterDto.builder()
//                .mark(1)
//                .yearFrom((short) 2000)
//                .yearBefore((short) 2030)
//                .odometerFrom((short) 20)
//                .odometerBefore((short) 100)
//                .powerBefore((int) 22)
                .sort(3)
                .build();

    }

    public FilterForm(final String query) {
        this.baseQuery = query;
    }

    public boolean isEmpty() {
        return query.isEmpty();
    }

    public void update(final FilterDto filter) {
        this.filterDto = filter;
        params.clear();

        addParam("status", Status.onSale);

        addParamID("city", filter.getCity(), true);

        addParamID("mark", filter.getMark(), true);
        addParamID("model", filter.getModel(), true);

        addFromParam("year", filter.getYearFrom());
        addBeforeParam("year", filter.getYearBefore());

        addFromParam("odometer", filter.getOdometerFrom());
        addBeforeParam("odometer", filter.getOdometerBefore());

        addFromParam("engineDisplacement", filter.getEngineDisplacementFrom());
        addBeforeParam("engineDisplacement", filter.getEngineDisplacementBefore());

        addFromParam("power", filter.getPowerFrom());
        addBeforeParam("power", filter.getPowerBefore());

        addFromParam("price", filter.getPriceFrom());
        addBeforeParam("price", filter.getPriceBefore());

        addParamID("body", filter.getBody(), true);
        addParamID("gearbox", filter.getGearbox(), false);
        addParamID("engine", filter.getEngine(), true);
        addParamID("transmission", filter.getTransmission(), false);

//        addSorting("sort", filter.getSort());
    }

    public String makeQuery() {
//        if (params.isEmpty()) {
//            return query;
//        }
        this.query = baseQuery
                .concat(" where")
                .concat(params.get(0).getQuery());
//        if (params.size() == 1) {
//            return query;
//        }
        for (int i = 1; i < params.size(); i++) {
            this.query = query
                    .concat(" and")
                    .concat(params.get(i).getQuery());
        }


        String sort = switch (filterDto.getSort()) {
            case 1 -> " ORDER BY c.price ASC";
            case 2 -> " ORDER BY c.price DESC";
            default -> " ORDER BY c.created DESC";
        };
        query = query.concat(sort);
//        log.info("{}", query);
        return query;
    }

    public Query<Car> setParameters(final Query<Car> query) {
        if (!params.isEmpty()) {
            params.forEach(n -> n.setParameter(query));
        }
        return query;
    }

    public FilterForm addFromParam(final String name, final Object from) {
        if (from != null) {
            params.add(new ElementForm<>(name, from, false) {
                @Override
                public String getQuery() {
                    return " c.".concat(name).concat(" > " + from);
                }

                @Override
                public Query<Car> setParameter(final Query<Car> query) {
                    return query;
                }
            });
        }
        return this;
    }

    public FilterForm addBeforeParam(final String name, final Object before) {
        if (before != null) {
            params.add(new ElementForm<>(name, before, false) {
                @Override
                public String getQuery() {
                    return " c.".concat(name).concat(" < " + before);
                }

                @Override
                public Query<Car> setParameter(final Query<Car> query) {
                    return query;
                }
            });
        }
        return this;
    }


    public FilterForm addSorting(final String name, final Object value) {
        if (value != null) {
            params.add(new ElementForm<>(name, value, false) {
                @Override
                public String getQuery() {
                    return query = switch (((int) value)) {
                        case 1 -> " ORDER BY c.price ASC";
                        case 2 -> " ORDER BY c.price DESC";
                        default -> " ORDER BY c.created DESC";
                    };
                }

                @Override
                public Query<Car> setParameter(final Query<Car> query) {
                    return query;
                }
            });
        }
        return this;
    }


    public FilterForm addParamID(final String name, final Object value, final boolean path) {
        if (value != null) {
            params.add(ElementForm.of(name, value, path));
        }
        return this;
    }

    public FilterForm addParam(final String name, final Object value) {
        if (value != null) {
            params.add(new ElementForm<>(name, value, false) {
                @Override
                public String getQuery() {
                    return " c.".concat(name).concat("=:").concat(name);
                }

                @Override
                public Query<Car> setParameter(final Query<Car> query) {
                    return query.setParameter(name, value);
                }
            });
        }
        return this;
    }

    @RequiredArgsConstructor(staticName = "of")
    private static class ElementForm<T> implements FilterFormIn<Car> {
        private final String name;
        private final T value;
        private final boolean path;

        @Override
        public String getQuery() {
            return " c.".concat(name).concat(".id").concat("=:").concat(name);
        }

        @Override
        public Query<Car> setParameter(final Query<Car> query) {
            return query.setParameter(name, value);
        }
    }

//    @RequiredArgsConstructor(staticName = "of")
//    private static class Field<V, T> {
//        private V value;
//        private List<T> options;
//    }
}

interface FilterFormIn<R> {
    String getQuery();

    Query<R> setParameter(Query<R> query);
}
