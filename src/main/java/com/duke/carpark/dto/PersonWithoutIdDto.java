package com.duke.carpark.dto;

import lombok.Value;

import java.time.LocalDate;
@Value
public class PersonWithoutIdDto {
    String passportNumber;
    String firstName;
    String surname;
    String patronymic;
    LocalDate birthDate;
    LocalDate startDrivingDate;
    String driverCategory;
}
