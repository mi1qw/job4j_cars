package com.example.car.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "generations")
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

    public Generations(final String name, final String image, final Short year,
                       final Mark mark, final Model model,
                       final Body body, final Engine engine, final Transmission transmission,
                       final Gearbox gearbox, final Modification modification) {
        this.name = mark.getName() + " " + model.getName() + " " + name;
        this.image = image;
        this.year = year;
        this.model = model;
        this.body = body;
        this.engine = engine;
        this.transmission = transmission;
        this.gearbox = gearbox;
        this.modification = modification;
    }
}
