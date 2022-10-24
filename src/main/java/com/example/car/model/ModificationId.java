package com.example.car.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ModificationId implements Serializable {

    @Column(name = "name", length = 30)
    private String nameId;

    @Column(name = "year_id")
    private Short yearId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "mark_id", nullable = false)
    private Mark markId;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ModificationId that = (ModificationId) o;

        if (!nameId.equals(that.nameId)) {
            return false;
        }
        if (!yearId.equals(that.yearId)) {
            return false;
        }
        return markId.getId().equals(that.getMarkId().getId());
    }

    @Override
    public int hashCode() {
        int result = nameId.hashCode();
        result = 31 * result + yearId.hashCode();
        result = 31 * result + markId.hashCode();
        return result;
    }
}
