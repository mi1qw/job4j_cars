package com.example.car.dto;

import com.example.car.model.Options;

import java.util.Objects;

public record OptionsDto(Options options, boolean isRestOption, boolean isOn) {
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OptionsDto that = (OptionsDto) o;
        return Objects.equals(options, that.options);
    }

    @Override
    public int hashCode() {
        return options != null ? options.hashCode() : 0;
    }
}
