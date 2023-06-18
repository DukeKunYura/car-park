package com.duke.carpark.services.impl;

import com.duke.carpark.dto.PersonWithCarsDto;
import com.duke.carpark.entity.Car;
import com.duke.carpark.entity.Person;
import com.duke.carpark.mappers.PersonMapper;
import com.duke.carpark.repository.CarRepository;
import com.duke.carpark.repository.PersonRepository;
import com.duke.carpark.services.PersonCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonCarServiceImpl implements PersonCarService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final CarRepository carRepository;

    @Override
    public PersonWithCarsDto addPersonCar(UUID personId, UUID carId) {
        Person person = personRepository.findPersonById(personId);
        Car car = carRepository.findCarById(carId);
        person.addCar(car);
        personRepository.save(person);

        return personMapper.toDtoWithCars(person);
    };

    @Override
    public PersonWithCarsDto removePersonCar(UUID personId, UUID carId) {
        Person person = personRepository.findPersonById(personId);
        Car car = carRepository.findCarById(carId);
        person.removeCar(car);
        personRepository.save(person);

        return personMapper.toDtoWithCars(person);
    };


}
