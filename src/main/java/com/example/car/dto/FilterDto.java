package com.example.car.dto;

import com.example.car.model.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Data
public class FilterDto {
    private Integer mark;
    private Integer model;

    private Short yearFrom;
    private Short yearBefore;

    private int odometerFrom;
    private int odometerBefore;

    private short engineDisplacementFrom;
    private short engineDisplacementBefore;

    private BigDecimal priceFrom;
    private BigDecimal priceBefore;

    private Integer body;
    private Integer gearbox;
    private Integer engine;
    private Integer transmission;
}
