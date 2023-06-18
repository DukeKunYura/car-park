package com.duke.carpark.dto;

import lombok.Value;

@Value
public class CarWithoutIdDto {
    String number;
    String vin;
    String brand;
    String model;
}
