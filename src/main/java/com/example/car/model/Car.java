package com.example.car.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime created;
    private String description;
    private BigDecimal price;
    private Short odometer;
    private Short year;
    private Short yearPurchase;
    private Short power;
    private Short engineDisplacement;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status = Status.newItem;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    private Generations generations;

    @ManyToOne(fetch = FetchType.LAZY)
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    private Mark mark;

    @ManyToOne(fetch = FetchType.LAZY)
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    private Body body;

    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Engine engine;

    @ManyToOne(fetch = FetchType.LAZY)
    private Transmission transmission;

    @ManyToOne(fetch = FetchType.LAZY)
    private Gearbox gearbox;

    private String modification;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Category> categories = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "history_owner",
            joinColumns = {
                    @JoinColumn(name = "car_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "driver_id", nullable = false, updatable = false)})
    private Set<Driver> drivers = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "image")
    @OrderColumn
    @Column(name = "filename")
    private List<String> images = new ArrayList<>();


    public Car(final String name, final Engine engine) {
        this.name = name;
        this.engine = engine;
    }
}
