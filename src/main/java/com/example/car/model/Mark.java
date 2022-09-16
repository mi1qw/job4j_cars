package com.example.car.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "mark")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String image;

    public Mark(final String name, final String image) {
        this.name = name;
        this.image = image;
    }
}
