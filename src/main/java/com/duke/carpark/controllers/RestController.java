package com.duke.carpark.controllers;

import com.duke.carpark.dto.CarDto;
import com.duke.carpark.dto.CarWithPersonDto;
import com.duke.carpark.dto.PersonDto;
import com.duke.carpark.dto.PersonWithCarsDto;
import com.duke.carpark.exceptions.ServerException;
import com.duke.carpark.services.CarService;
import com.duke.carpark.services.PersonCarService;
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
    private final PersonCarService personCarService;

    // получение всех водителей
    @GetMapping(value = "persons")
    @Operation(summary = "all persons", description = "get all persons")
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    // получение водителя по ID
    @GetMapping(value = "person")
    @Operation(summary = "person by ID", description = "get person by ID")
    public ResponseEntity<PersonDto> getPersonById(
            @RequestParam(name = "id", required = false) UUID id) {
        try {
            PersonDto personDto = personService.getPersonById(id);
            return ResponseEntity.status(HttpStatus.OK).body(personDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // получение водителя по ID с автомобилями
    @GetMapping(value = "person_with_cars")
    @Operation(summary = "person with cars by ID", description = "get person with cars by ID")
    public ResponseEntity<PersonWithCarsDto> getPersonWithCarsById(
            @RequestParam(name = "id", required = false) UUID id) {
        try {
            PersonWithCarsDto person = personService.getPersonWithCarsById(id);
            return ResponseEntity.status(HttpStatus.OK).body(person);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // получение всех автомобилей
    @GetMapping(value = "cars")
    @Operation(summary = "all cars", description = "get all cars")
    public List<CarWithPersonDto> getAllCars() {
        return carService.getAllCarsWithPerson();
    }

    // получение автомобиля по ID
    @GetMapping(value = "car")
    @Operation(summary = "car by ID", description = "get car by ID")
    public ResponseEntity<CarDto> getCarById(
            @RequestParam(name = "id", required = false) UUID id) {
        try {
            CarDto carDto = carService.getCarById(id);
            return ResponseEntity.status(HttpStatus.OK).body(carDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // добавление водителя
    @PostMapping(path = "person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "add person", description = "add new person")
    public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto newPerson) {
        if (newPerson == null) {
            throw new ServerException();
        } else {
            PersonDto person = personService.addPerson(newPerson);
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        }
    }

    // добавление автомобиля
    @PostMapping(path = "car", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "add car", description = "add new car")
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto newCar) {
        if (newCar == null) {
            throw new ServerException();
        } else {
            CarDto car = carService.addCar(newCar);
            return new ResponseEntity<>(car, HttpStatus.CREATED);
        }
    }

    // добавление авто водителю по их ID
    @PutMapping(path = "add_person_car")
    @Operation(summary = "add person car", description = "add car to person")
    public ResponseEntity<PersonWithCarsDto> addPersonCarById(@RequestParam(name = "person") UUID personId,
                                                   @RequestParam(name = "car") UUID carId) {
        PersonWithCarsDto person = personCarService.addPersonCar(personId, carId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
