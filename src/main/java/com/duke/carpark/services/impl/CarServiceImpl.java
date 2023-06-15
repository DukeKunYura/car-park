package com.duke.carpark.services.impl;

import com.duke.carpark.dto.CarDto;
import com.duke.carpark.dto.CarWithPersonDto;
import com.duke.carpark.entity.Car;
import com.duke.carpark.mappers.CarMapper;
import com.duke.carpark.repository.CarRepository;
import com.duke.carpark.services.CarService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public List<CarWithPersonDto> getAllCarsWithPerson() {
        List<Car> carsList = carRepository.findAll();
        List<CarWithPersonDto> carsListDto = new ArrayList<>();
        for (Car car : carsList) {
            carsListDto.add(carMapper.toDtoWithPerson(car));
        }
        return carsListDto;
    }

    @Override
    public CarDto getCarById(UUID id) {
        Car car = carRepository.findById(id).orElseThrow();
        return carMapper.toDto(car);
    }

    @Override
    public void addCar(CarDto dto) {
        Car car = carMapper.toEntity(dto);
        carRepository.save(car);
    }
}
