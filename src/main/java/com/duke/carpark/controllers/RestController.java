package com.duke.carpark.controllers;

import com.duke.carpark.dto.CarDto;
import com.duke.carpark.dto.CarWithPersonDto;
import com.duke.carpark.dto.PersonDto;
import com.duke.carpark.dto.PersonWithCarsDto;
import com.duke.carpark.exceptions.ServerException;
import com.duke.carpark.services.impl.CarServiceImpl;
import com.duke.carpark.services.impl.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@org.springframework.web.bind.annotation.RestController("/")
@CrossOrigin(origins = "http://localhost:8085")
@RequiredArgsConstructor
public class RestController {
    private final PersonServiceImpl personService;
    private final CarServiceImpl carService;

    @GetMapping(value = "persons")
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(value = "person")
    public PersonDto gerPersonById(
            @RequestParam(name = "id") UUID id) {
        return personService.getPersonById(id);
    }

    @GetMapping(value = "person_with_cars")
    public PersonWithCarsDto getPersonWithCarsById(
            @RequestParam(name = "id") UUID id) {
        return personService.getPersonWithCarsById(id);
    }

    @GetMapping(value = "cars")
    public List<CarWithPersonDto> getAllCars() {
        return carService.getAllCarsWithPerson();
    }

    @GetMapping(value = "car")
    public CarDto gerCarById(
            @RequestParam(name = "id") UUID id) {
        return carService.getCarById(id);
    }

    @PostMapping(path = "person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto newPerson) {
        if (newPerson == null) {
            throw new ServerException();
        } else {
            personService.addPerson(newPerson);
            return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
        }
    }

    @PostMapping(path = "car", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto newCar) {
        if (newCar == null) {
            throw new ServerException();
        } else {
            carService.addCar(newCar);
            return new ResponseEntity<>(newCar, HttpStatus.CREATED);
        }
    }
}
