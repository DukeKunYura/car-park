package com.duke.carpark.controllers;

import com.duke.carpark.dto.CarDto;
import com.duke.carpark.dto.CarWithPersonDto;
import com.duke.carpark.dto.PersonDto;
import com.duke.carpark.dto.PersonWithCarsDto;
import com.duke.carpark.exceptions.ServerException;
import com.duke.carpark.services.CarService;
import com.duke.carpark.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "REST controller", description = "available operations")
public class RestController {
    private final PersonService personService;
    private final CarService carService;

    @GetMapping(value = "persons")
    @Operation(summary = "all persons", description = "get all persons")
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(value = "person")
    @Operation(summary = "person by ID", description = "get person by ID")
    public PersonDto gerPersonById(
            @RequestParam(name = "id") UUID id) {
        return personService.getPersonById(id);
    }

    @GetMapping(value = "person_with_cars")
    @Operation(summary = "person with cars by ID", description = "get person with cars by ID")
    public PersonWithCarsDto getPersonWithCarsById(
            @RequestParam(name = "id") UUID id) {
        return personService.getPersonWithCarsById(id);
    }

    @GetMapping(value = "cars")
    @Operation(summary = "all cars", description = "get all cars")
    public List<CarWithPersonDto> getAllCars() {
        return carService.getAllCarsWithPerson();
    }

    @GetMapping(value = "car")
    @Operation(summary = "car by ID", description = "get car by ID")
    public CarDto gerCarById(
            @RequestParam(name = "id") UUID id) {
        return carService.getCarById(id);
    }

    @PostMapping(path = "person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "add person", description = "add new person")
    public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto newPerson) {
        if (newPerson == null) {
            throw new ServerException();
        } else {
            personService.addPerson(newPerson);
            return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
        }
    }

    @PostMapping(path = "car", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "add car", description = "add new car")
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto newCar) {
        if (newCar == null) {
            throw new ServerException();
        } else {
            carService.addCar(newCar);
            return new ResponseEntity<>(newCar, HttpStatus.CREATED);
        }
    }
}
