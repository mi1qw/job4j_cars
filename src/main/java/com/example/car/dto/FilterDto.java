package com.example.car.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Data
@Builder
//@NoArgsConstructor
public class FilterDto implements Cloneable {
    private Long mark;
    private Long model;

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

    private Long body;
    private Long gearbox;
    private Long engine;
    private Long transmission;

    private Long city;
    private Integer sort;

    @Override
    public FilterDto clone() {
        try {
            return (FilterDto) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
