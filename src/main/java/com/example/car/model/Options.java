package com.example.car.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "options")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String nameCategory;

    @Column(unique = true, nullable = false, length = 80)
    private String name;

    public Options(final String nameCategory, final String name) {
        this.nameCategory = nameCategory;
        this.name = name;
    }
}
