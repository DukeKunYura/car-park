package com.duke.carpark.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;
@Data
public class PersonDto {
    private UUID id;
    private String passportNumber;
    private String firstName;
    private String surname;
    private String patronymic;
    private LocalDate birthDate;
    private LocalDate startDrivingDate;
    private String driverCategory;
}
