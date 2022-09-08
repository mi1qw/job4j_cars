package com.example.car.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class CarDto implements Serializable {
    @NotNull(message = "0")
    private int odometer;

    @Min(value = 1900, message = "Неверный год")
    @NotNull
    private Short yearPurchase;

    private String description;

    @NotNull(message = "Укажите цену")
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal price;

    @NotNull
    @NotBlank(message = "Добавьте фотографии")
    private String images;
}
