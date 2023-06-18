package com.duke.carpark.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class PersonWithAccountsDto {
    private UUID id;
    private String passportNumber;
    private String firstName;
    private String surname;
    private String patronymic;
    private LocalDate birthDate;
    private LocalDate startDrivingDate;
    private String driverCategory;
    private List<AccountDto> accounts;

    public void setAccounts(List<AccountDto> accounts) {
        this.accounts = new ArrayList<>(accounts);
    }
}

