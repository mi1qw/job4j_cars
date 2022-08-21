package com.example.car.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
@Table(name = "engine")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    public Engine(final String name) {
        this.name = name;
    }

    public Engine(final String name, final String image) {
        this.name = name;
        this.image = image;
    }
}
