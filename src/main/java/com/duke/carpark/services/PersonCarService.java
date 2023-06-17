package com.duke.carpark.services;

import com.duke.carpark.dto.PersonWithCarsDto;

import java.util.UUID;

public interface PersonCarService {

    public PersonWithCarsDto addPersonCar(UUID personId, UUID carId);
}
