package com.example.car.service.dto;

import com.example.car.model.Car;

import java.util.List;

public record PaginationDto(List<Car> cars, int pages) {
}
