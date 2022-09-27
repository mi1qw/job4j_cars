package com.example.car.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Data
@Builder
public class FilterDto {
    private Integer mark;
    private Integer model;

    private Short yearFrom;
    private Short yearBefore;

    private Short odometerFrom;
    private Short odometerBefore;

    private Short engineDisplacementFrom;
    private Short engineDisplacementBefore;

    private Short powerFrom;
    private Integer powerBefore;

    private BigDecimal priceFrom;
    private BigDecimal priceBefore;

    private Integer body;
    private Integer gearbox;
    private Integer engine;
    private Integer transmission;

    private Integer city;
    private Integer sort;
}
