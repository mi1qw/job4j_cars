package com.example.car.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashSet;
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
    private int odometer;
    private boolean status;
    private String year;

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
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"),
            nullable = false)
    private Engine engine;

    @ManyToOne(fetch = FetchType.LAZY)
    private Transmission transmission;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "history_owner",
            joinColumns = {
                    @JoinColumn(name = "car_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "driver_id", nullable = false, updatable = false)})
    private Set<Driver> drivers = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "image",
            joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "filename")
    private Set<String> images = new HashSet<>();

    public Car(final String name, final Engine engine) {
        this.name = name;
        this.engine = engine;
    }
}
