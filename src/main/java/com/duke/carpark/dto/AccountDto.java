package com.duke.carpark.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AccountDto {
    private UUID id;
    private String number;
    private String title;
    private BigDecimal score;
}
