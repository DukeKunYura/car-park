package com.duke.carpark.services.impl;

import com.duke.carpark.dto.CarWithDetailsDto;
import com.duke.carpark.dto.PersonWithCarsDto;
import com.duke.carpark.entity.Car;
import com.duke.carpark.entity.Detail;
import com.duke.carpark.mappers.CarMapper;
import com.duke.carpark.repository.CarRepository;
import com.duke.carpark.repository.DetailRepository;
import com.duke.carpark.services.CarDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarDetailServiceImpl implements CarDetailService {
    private final CarRepository carRepository;
    private final DetailRepository detailRepository;
    private final CarMapper carMapper;

    @Override
    public CarWithDetailsDto addCarDetail(UUID carId, UUID detailId) {
        Car car = carRepository.findCarById(carId);
        Detail detail = detailRepository.findDetailById(detailId);
        car.addDetail(detail);
        carRepository.save(car);

        return carMapper.toDtoWithDetails(car);
    };

    @Override
    public CarWithDetailsDto removeCarDetail(UUID carId, UUID detailId) {
        Car car = carRepository.findCarById(carId);
        Detail detail = detailRepository.findDetailById(detailId);
        car.removeDetail(detail);
        carRepository.save(car);

        return carMapper.toDtoWithDetails(car);
    };
}
