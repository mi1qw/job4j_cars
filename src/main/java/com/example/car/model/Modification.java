package com.example.car.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "modification")
public class Modification {
    @EmbeddedId
    private ModificationId id;
    private short power;
    private short engineDisplacement;
    private byte numberOfCylinders;
    @Column(length = 15)
    private String positionOfCylinders;
}
