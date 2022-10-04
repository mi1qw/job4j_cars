package com.example.car.dto;

import com.example.car.model.City;
import com.example.car.model.Options;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
public class CarDto implements Serializable {

    private Set<Options> options;

    @NotNull(message = "Укажите пробег")
    private Short odometer;

    @Min(value = 1900, message = "Неверный год")
    @NotNull
    private Short yearPurchase;

    @NotNull(message = "Выберите город")
    private City city;

    private String description;

    @NotNull(message = "Укажите цену")
    private BigDecimal price;

    @NotNull
    @NotBlank(message = "Добавьте фотографии")
    private String images;
}
