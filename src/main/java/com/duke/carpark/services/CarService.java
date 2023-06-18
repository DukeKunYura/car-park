package com.duke.carpark.services;

import java.util.List;
import java.util.UUID;

import com.duke.carpark.dto.CarDto;
import com.duke.carpark.dto.CarWithPersonDto;
import com.duke.carpark.dto.CarWithoutIdDto;

public interface CarService {

    public List<CarWithPersonDto> getAllCarsWithPerson();

    public CarDto getCarById(UUID id);

    public CarDto addCar(CarWithoutIdDto newCar);
}