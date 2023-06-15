package com.duke.carpark.dto;

import lombok.Data;

import java.util.UUID;
@Data
public class CarDto {
    private UUID id;
    private String number;
    private String vin;
    private String brand;
    private String model;
}
