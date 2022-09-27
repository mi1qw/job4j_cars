package com.example.car.dto;

import com.example.car.model.City;
import com.example.car.validation.ValidationGroupOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class CarDto implements Serializable {
    @NotNull(message = "Укажите пробег")
    private Short odometer;

    @Min(value = 1900, message = "Неверный год")
    @NotNull
    private Short yearPurchase;

    @NotNull(message = "Выберите город")
    private City city;

    private String description;

    @NotNull(message = "Укажите цену")
//    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal price;

    @NotNull
    @NotBlank(message = "Добавьте фотографии")
    private String images;
}
