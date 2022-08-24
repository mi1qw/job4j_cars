package com.example.car.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class CarDto implements Serializable {
    private int odometer;
    private String yearPurchase;
    private String description;
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal price;
    private String images;
}
