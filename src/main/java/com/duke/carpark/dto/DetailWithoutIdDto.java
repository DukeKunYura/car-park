package com.duke.carpark.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class DetailWithoutIdDto {
    String serialNumber;
    String title;
    BigDecimal price;
}
