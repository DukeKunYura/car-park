package com.duke.carpark.dto;

import com.duke.carpark.entity.Person;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import java.util.UUID;
@Data
public class CarWithPersonDto {
    private UUID id;
    private String number;
    private String vin;
    private String brand;
    private String model;
    private PersonDto person;

    public void setPerson(PersonDto dto) {
        this.person = dto;
    }
}
