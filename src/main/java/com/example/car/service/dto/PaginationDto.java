package com.example.car.service.dto;

import com.example.car.model.Car;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor(staticName = "of")
public record PaginationDto(List<Car> cars, int rowNumber) {
}
