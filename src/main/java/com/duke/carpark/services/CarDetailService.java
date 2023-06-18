package com.duke.carpark.services;

import com.duke.carpark.dto.CarWithDetailsDto;

import java.util.UUID;

public interface CarDetailService {
    CarWithDetailsDto addCarDetail(UUID carId, UUID detailId);
}
