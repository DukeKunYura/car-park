package com.duke.carpark.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class AccountWithoutIdDto {
    String number;
    String title;
    BigDecimal score;
}
