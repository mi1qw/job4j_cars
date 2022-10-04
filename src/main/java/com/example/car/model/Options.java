package com.example.car.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "options")
@Slf4j
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameCategory;

    @Column(unique = true)
    private String name;

    public Options(final String nameCategory, final String name) {
        this.nameCategory = nameCategory;
        this.name = name;
    }
}
