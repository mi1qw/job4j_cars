package com.example.car.dto;

import com.example.car.model.*;
import com.example.car.service.MarkService;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Slf4j


@Builder

public class PostDto {
    @Autowired
    private MarkService markService;

    private Long id;
    @Getter(lazy = true)
    private final Mark mark = markService.findById(1L);
    private Model model;
    private Short year;

    private short engineDisplacement;
    private BigDecimal price;
    private Body body;
    private Gearbox gearbox;
    private Engine engine;
    private Transmission transmission;


    private final String name;
    private LocalDateTime created;
    private String description;
    private Short odometer;
    private Short yearPurchase;
    private Short power;

    private Account account;
    private Color color;
    private String modification;
    private List<String> images;

}
