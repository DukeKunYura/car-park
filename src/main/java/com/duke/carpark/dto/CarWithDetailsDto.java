package com.duke.carpark.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class CarWithDetailsDto {
    private UUID id;
    private String number;
    private String vin;
    private String brand;
    private String model;
    List<DetailDto> details = new ArrayList<>();

    public void setDetails(List<DetailDto> details) {
        this.details = new ArrayList<>(details);
    }
}
