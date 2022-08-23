package com.example.car.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ModificationId implements Serializable {

    @Column(name = "name")
    private String nameId;

    @Column(name = "year_id")
    private Short yearId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "mark_id", nullable = false)
    private Mark markId;
}
