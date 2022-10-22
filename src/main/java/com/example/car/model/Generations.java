package com.example.car.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "generations",
        uniqueConstraints = @UniqueConstraint(columnNames =
                {"name", "year", "body_id", "engine_id", "gearbox_id", "model_id", "mark_id",
                        "name_id", "year_id", "transmission_id"}))
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Generations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private Short year;

    @ManyToOne(fetch = FetchType.LAZY)
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    private Body body;

    @ManyToOne(fetch = FetchType.LAZY)
    private Engine engine;

    @ManyToOne(fetch = FetchType.LAZY)
    private Transmission transmission;

    @ManyToOne(fetch = FetchType.LAZY)
    private Gearbox gearbox;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "mark_id", referencedColumnName = "mark_id"),
            @JoinColumn(name = "name_id", referencedColumnName = "name"),
            @JoinColumn(name = "year_id", referencedColumnName = "year_id")
    })
    private Modification modification;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "generations_options")
    private Set<Options> options = new HashSet<>();
}
