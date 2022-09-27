package com.example.car.util;

import com.example.car.model.City;
import com.example.car.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CityFormatter implements Formatter<City> {
    @Autowired
    private CityService cityService;

    public CityFormatter() {
        super();
    }

    @Override
    public City parse(final String text, final Locale locale) throws ParseException {
        Long id = Long.valueOf(text);
        return cityService.findById(id);
    }

    @Override
    public String print(final City object, final Locale locale) {
        return (object != null ? object.getId().toString() : "");
    }
}
