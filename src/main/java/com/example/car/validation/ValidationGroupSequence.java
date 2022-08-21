package com.example.car.validation;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({Default.class, ValidationGroupOne.class,
        ValidationGroupTwo.class})
public interface ValidationGroupSequence {
}
