package com.duke.carpark.filters;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PersonFilter {
    private UUID id;
    private String passportNumber;
    private String firstName;
    private String surname;
    private String patronymic;
    private LocalDate birthDate;
    private LocalDate startDrivingDate;
    private String driverCategory;
    private LocalDate minAgeDate;
    private LocalDate maxAgeDate;
    private LocalDate minStartDrivingDate;
    private LocalDate maxStartDrivingDate;

    public boolean isEmpty() {
        return this.id == null
                && this.passportNumber == null
                && this.firstName == null
                && this.surname == null
                && this.patronymic == null
                && this.birthDate == null
                && this.minAgeDate == null
                && this.maxAgeDate == null
                && this.minStartDrivingDate == null
                && this.maxStartDrivingDate == null;

    }
}
