package com.example.car.dto;

import com.example.car.model.Car;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", imports = {org.thymeleaf.util.StringUtils.class,
        java.util.Arrays.class})
public interface CarMapper {
    @Mapping(target = "images", constant = "")
    CarDto carToDto(Car car);

    @Mapping(target = "images", expression =
            "java( Arrays.stream(StringUtils.split(carDto.getImages(), \"|\")).toList() )")
    Car dtoToCar(CarDto carDto);

    @InheritConfiguration
    void updateCar(CarDto carDto, @MappingTarget Car car);
}
