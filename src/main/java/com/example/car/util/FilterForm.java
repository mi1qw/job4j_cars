package com.example.car.util;

import com.example.car.dto.FilterDto;
import com.example.car.model.Car;
import com.example.car.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * FilterForm for main paige.
 * По умолчанию только сортировка "Сначала новые"=3.
 * FilterDto можно хранить в бд и подставлять при создании сессии
 */
@Slf4j
@Data
public class FilterForm {
    private FilterDto filterDto;
    private String baseQuery;
    private String query;
    private List<ElementForm> params = new ArrayList<>();

    public FilterForm() {
        this.baseQuery = "select c from Car c";
        this.filterDto = FilterDto.builder()
                .sort(3)
                .build();
    }

    public FilterForm(final FilterDto filterDto) {
        this.baseQuery = "select c from Car c";
        this.filterDto = filterDto;
        update(filterDto);
    }

    public boolean isEmpty() {
        return query == null;
    }

    public void update(final FilterDto filter) {
        this.filterDto = filter;
        params.clear();

        addParam("status", Status.onSale, (n) -> {
        });

        addParamID("city", filter.getCity(), true, (n) -> n.setCity(null));

        addParamID("mark", filter.getMark(), true, (n) -> n.setMark(null));
        addParamID("model", filter.getModel(), true, (n) -> n.setModel(null));

        addFromParam("year", filter.getYearFrom(), (n) -> n.setYearFrom(null));
        addBeforeParam("year", filter.getYearBefore(), (n) -> n.setYearBefore(null));

        addFromParam("odometer", filter.getOdometerFrom(), (n) -> n.setOdometerFrom(null));
        addBeforeParam("odometer", filter.getOdometerBefore(), (n) -> n.setOdometerBefore(null));

        addFromParam("engineDisplacement", filter.getEngineDisplacementFrom(),
                (n) -> n.setEngineDisplacementFrom(null));
        addBeforeParam("engineDisplacement", filter.getEngineDisplacementBefore(),
                (n) -> n.setEngineDisplacementBefore(null));

        addFromParam("power", filter.getPowerFrom(), (n) -> n.setPowerFrom(null));
        addBeforeParam("power", filter.getPowerBefore(), (n) -> n.setPowerBefore(null));

        addFromParam("price", filter.getPriceFrom(), (n) -> n.setPriceFrom(null));
        addBeforeParam("price", filter.getPriceBefore(), (n) -> n.setPriceBefore(null));

        addParamID("body", filter.getBody(), true, (n) -> n.setBody(null));
        addParamID("gearbox", filter.getGearbox(), false, (n) -> n.setGearbox(null));
        addParamID("engine", filter.getEngine(), true, (n) -> n.setEngine(null));
        addParamID("transmission", filter.getTransmission(), false, (n) -> n.setTransmission(null));

//        addSorting("sort", filter.getSort());
    }

    public FilterForm sliceFilter(final String element) {
        boolean flag = true;
        Iterator<ElementForm> iterator = params.iterator();
        while (iterator.hasNext()) {
            ElementForm<?> param = iterator.next();
            if (param.isSliced()) {
                if (flag) {
                    flag = !param.name.equals(element);
                } else {
                    param.field.accept(filterDto);
                    iterator.remove();
                }
            }
        }
        return this;
    }

    public String makeQuery() {
        this.query = baseQuery
                .concat(" where")
                .concat(params.get(0).getQuery());
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
        return query;
    }

    public Query<Car> setParameters(final Query<Car> query) {
        if (!params.isEmpty()) {
            params.forEach(n -> n.setParameter(query));
        }
        return query;
    }

    public <T> FilterForm addFromParam(final String name, final T from,
                                       final Consumer<FilterDto> resetField) {
        if (from != null) {
            params.add(new ElementForm<>(name, from, false, resetField) {
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

    public <T> FilterForm addBeforeParam(final String name, final T before,
                                         final Consumer<FilterDto> resetField) {
        if (before != null) {
            params.add(new ElementForm<>(name, before, false, resetField) {
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


    public <T> FilterForm addSorting(final String name, final T value,
                                     final Consumer<FilterDto> resetField) {
        if (value != null) {
            params.add(new ElementForm<>(name, value, false, resetField) {
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


    public <T> FilterForm addParamID(final String name, final T value, final boolean isSliced,
                                     final Consumer<FilterDto> resetField) {
        if (value != null) {
            params.add(new ElementForm<>(name, value, isSliced, resetField));
        }
        return this;
    }

    public <T> FilterForm addParam(final String name, final T value,
                                   final Consumer<FilterDto> resetField) {
        if (value != null) {
            params.add(new ElementForm<>(name, value, false, resetField) {
                @Override
                public String getQuery() {
                    return " c.".concat(name).concat("=:").concat(name);
                }
            });
        }
        return this;
    }

    @Data
    @AllArgsConstructor
    private static class ElementForm<T> {
        private final String name;
        private final T value;
        private final boolean isSliced;
        private final Consumer<FilterDto> field;

        public String getQuery() {
            return " c.".concat(name).concat(".id").concat("=:").concat(name);
        }

        public Query<Car> setParameter(final Query<Car> query) {
            return query.setParameter(name, value);
        }
    }
}
