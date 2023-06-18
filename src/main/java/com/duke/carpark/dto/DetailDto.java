package com.duke.carpark.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class DetailDto {
    private UUID id;
    private String serialNumber;
    private String title;
    private BigDecimal price;
}
