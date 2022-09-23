package com.example.car.dto;

import com.example.car.model.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class PostDto {
//    @Autowired
//    private MarkService markService;

    private Long id;
    //    @Getter(lazy = true)
//    private final Mark mark = markService.findById(1L);
    private Mark mark;
    private Model model;
    private Short year;

    private short engineDisplacement;
    private BigDecimal price;
    private Body body;
    private Gearbox gearbox;
    private Engine engine;
    private Transmission transmission;

    private byte numberOfCylinders;
    private String positionOfCylinders;

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
