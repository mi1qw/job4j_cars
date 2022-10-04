package com.example.car.util;

import com.example.car.model.City;
import com.example.car.model.Options;
import com.example.car.service.CityService;
import com.example.car.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class OptionsFormatter implements Formatter<Options> {
    @Autowired
    private OptionsService optionsService;

    public OptionsFormatter() {
        super();
    }

    @Override
    public Options parse(final String text, final Locale locale) throws ParseException {
        Long id = Long.valueOf(text);
        return optionsService.findById(id);
    }

    @Override
    public String print(final Options object, final Locale locale) {
        return (object != null ? object.getId().toString() : "");
    }
}
