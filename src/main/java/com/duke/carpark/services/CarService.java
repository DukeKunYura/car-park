package com.duke.carpark.services;

import java.util.List;
import java.util.UUID;

import com.duke.carpark.dto.CarDto;
import com.duke.carpark.dto.CarWithPersonDto;

public interface CarService {

    public List<CarWithPersonDto> getAllCarsWithPerson();

    public CarDto getCarById(UUID id);

    public void addCar(CarDto newCar);
}