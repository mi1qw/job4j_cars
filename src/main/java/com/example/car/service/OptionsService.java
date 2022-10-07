package com.example.car.service;

import com.example.car.dto.OptionsDto;
import com.example.car.model.Options;
import com.example.car.store.OptionsStore;
import com.example.car.web.UserSession;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@Slf4j
public class OptionsService {
    private final OptionsStore optionsStore;
    private final UserSession userSession;
    @Getter
    private final Map<Long, Options> optionsMap = new HashMap<>();

    public OptionsService(final OptionsStore optionsStore,
                          final UserSession userSession) {
        this.optionsStore = optionsStore;
        this.userSession = userSession;
        optionsStore.findAll().forEach(n -> optionsMap.put(n.getId(), n));
    }

    public List<Options> findAll() {
        return optionsMap.values().stream().toList();
    }

    public Map<Long, Options> findAllMap() {
        return optionsMap;
    }

    public Options findById(final Long id) {
        return optionsMap.get(id);
    }

    public Set<Options> getRestOfOptions(final Set<Options> carOpts) {
        return optionsMap.values().stream()
                .filter(n -> !carOpts.contains(n))
                .collect(Collectors.toSet());
    }


    public Set<Options> findGenerationOptionsById(final Long id) {
        Set<Options> options = new HashSet<>();
        userSession.getCarState().setOptionsGeneration(options);
        optionsStore.findGenerationOptionsById(id)
                .forEach(n -> options.add(optionsMap.get(n)));
        return options;
    }


    public Map<String, Map<Boolean, Map<Boolean, List<OptionsDto>>>>
    getOptionsDto(final Set<Options> carOptions, final long id) {
        Map<Long, OptionsDto> options = new HashMap<>();
        findGenerationOptionsById(id)
                .forEach(n -> options.put(
                        n.getId(),
                        new OptionsDto(n, false, true)
                ));

        carOptions.forEach(n -> options.putIfAbsent(
                n.getId(),
                new OptionsDto(n, true, true)
        ));

        optionsMap.values().forEach(n -> options.putIfAbsent(
                n.getId(),
                new OptionsDto(n, true, false)
        ));

        return options.values().stream()
                .collect(groupingBy(n -> n.options().getNameCategory(),
                        partitioningBy(OptionsDto::isRestOption,
                                partitioningBy(OptionsDto::isOn, toList()))));
    }
}
