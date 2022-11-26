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
    @Column(length = 80)
    private String name;
    private LocalDateTime created;
    @Version
    private LocalDateTime lastUpdated;
    @Column(length = 1000)
    private String description;
    private BigDecimal price;
    private Short odometer;
    @Column(name = "yearc")
    private Short year;
    private Short yearPurchase;
    private Short power;
    private Short engineDisplacement;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status = Status.newItem;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Engine engine;

    @ManyToOne(fetch = FetchType.LAZY)
    private Transmission transmission;

    @ManyToOne(fetch = FetchType.LAZY)
    private Gearbox gearbox;

    @ManyToOne(fetch = FetchType.LAZY)
    private Modification modification;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Options> options = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "image")
    @OrderColumn
    @Column(name = "filename")
    private List<String> images = new ArrayList<>();


    public Car(final String name, final Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{id=" + id + '}';
    }
}
