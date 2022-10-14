package com.example.car.util;

import com.example.car.dto.OptionsDto;
import com.example.car.model.*;
import com.example.car.service.GenerationsService;
import com.example.car.service.MarkService;
import com.example.car.service.ModelService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Slf4j
@Data
public class CarState {
    private List<State<?, ?>> stepList = new ArrayList<>();
    private boolean isDone = false;
    private int[] steps = {0};
    private List<Generations> generations;
    private Map<String, Map<Boolean, Map<Boolean, List<OptionsDto>>>> optionsDto;
    private Set<Options> optionsGeneration;
    private Long generationID;

    public void addStep(final String name, final Supplier<Map<?, ?>> supplier) {
        stepList.add(new State(steps, name, supplier));
    }

    public boolean isDone() {
        return stepList.stream().allMatch(n -> n.status);
    }

    public Map<Long, Mark> getMarks(final MarkService markService) {
        return markService.findAllMap();
    }

    public Map<Long, Model> getModelsByMark(final ModelService modelService) {
        Mark mark = (Mark) stepList.get(0).value;
        return modelService.getModelsByMark(mark);
    }

    public Map<Long, Short> getGenerationsByYear(final GenerationsService generationsService) {
        Model model = (Model) stepList.get(1).value;
        return generationsService.getYearsByModel(model);
    }

    public Map<Long, Body> getBodiesByYearByModel(final GenerationsService generationsService) {
        Model modelvalue = (Model) stepList.get(1).value;
        Short yearvalue = (Short) stepList.get(2).value;
        // TODO сделать модель в таблице уникальным по имени
        generations = generationsService.getGenerationsByYearByModel(yearvalue, modelvalue);
        return generations.stream()
                .map(Generations::getBody)
                .distinct()
                .collect(Collectors.toMap(Body::getId, Function.identity()));
    }

    public Map<Long, Img> getGenerationsByImg() {
        Body body = (Body) stepList.get(3).value;
        generations = generations.stream()
                .filter(n -> n.getBody().equals(body))
                .collect(Collectors.toList());
        AtomicLong id = new AtomicLong();
        return generations.stream()
                .filter(distinctByKey(Generations::getImage))
                .collect(Collectors.toMap((n) -> id.get(),
                        (n) -> new Img(id.getAndIncrement(), n.getName(), n.getImage())));
    }

    public Map<Long, Engine> getGenerationsByEngine() {
        Img img1 = (Img) stepList.get(4).value;
        String img = img1.name;
        generations = generations.stream()
                .filter(n -> n.getName().equals(img))
                .collect(Collectors.toList());
        return generations.stream()
                .map(Generations::getEngine)
                .distinct()
                .collect(Collectors.toMap(Engine::getId, Function.identity()));
    }

    public Map<Long, Transmission> getGenerationsByTransmission() {
        Engine engine = (Engine) stepList.get(5).value;
        generations = generations.stream()
                .filter(n -> n.getEngine().equals(engine))
                .collect(Collectors.toList());
        return generations.stream()
                .map(Generations::getTransmission)
                .distinct()
                .collect(Collectors.toMap(Transmission::getId, Function.identity()));
    }

    public Map<Long, Gearbox> getGenerationsByGear() {
        Transmission transmission = (Transmission) stepList.get(6).value;
        generations = generations.stream()
                .filter(n -> n.getTransmission().equals(transmission))
                .collect(Collectors.toList());
        return generations.stream()
                .map(Generations::getGearbox)
                .distinct()
                .collect(Collectors.toMap(Gearbox::getId, Function.identity()));
    }

    public Map<Long, GenMod> getGenerationsModification() {
        Gearbox gearbox = (Gearbox) stepList.get(7).value;
        generations = generations.stream()
                .filter(n -> n.getGearbox().equals(gearbox))
                .collect(Collectors.toList());
        return generations.stream()
                .collect(Collectors.toMap(Generations::getId,
                        (n) -> new GenMod(
                                n.getId(),
                                n.getModification().getId().getNameId())));
    }

    public record Img(Long id, String name, String image) {
    }

    public record GenMod(Long id, String name) {
    }

    public static <T> Predicate<T> distinctByKey(final Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    @Data
    public static class State<T, R> {
        private String name;
        private int step;
        private boolean status = false;
        private Supplier<Map<Long, R>> optionsSup;
        private Map<Long, R> options = new HashMap<>();
        private R value;
        private List<Generations> prevGenerations;

        public State(final int[] steps, final String name,
                     final Supplier<Map<Long, R>> optionsSup) {
            this.step = steps[0]++;
            this.name = name;
            this.optionsSup = optionsSup;
        }

        public void setValue(final Object value) {
            this.value = (R) value;
            this.status = true;
        }

        public Map<Long, R> makeOptions() {
            if (options.isEmpty()) {
                options.putAll(optionsSup.get());
            }
            return options;
        }

        public R getOptionByID(final long id) {
            return options.get(id);
        }

        public void setOption(final Object value) {
            this.value = (R) value;
            status = true;
        }

        public void resetOption() {
            this.value = null;
            options.clear();
            status = false;
        }

        public void resetStatusGen(final List<Generations> generations) {
            this.value = null;
            status = false;
            if (prevGenerations != null) {
                generations.clear();
                generations.addAll(prevGenerations);
            }
        }

        public void resetStatus() {
            this.value = null;
            status = false;
        }
    }
}
