package com.duke.carpark.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
public class PersonWithCarsDto {
    private UUID id;
    private String passportNumber;
    private String firstName;
    private String surname;
    private String patronymic;
    private LocalDate birthDate;
    private LocalDate startDrivingDate;
    private String driverCategory;
    private List<CarDto> cars;

    public void setCars(List<CarDto> cars) {
        List<CarDto> carsListDto = new ArrayList<>();
        for (CarDto car : cars) {
            carsListDto.add(car);
        }
        this.cars = carsListDto;
    }
}
