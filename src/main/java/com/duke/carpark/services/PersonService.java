package com.duke.carpark.services;

import java.util.List;
import java.util.UUID;

import com.duke.carpark.dto.PersonDto;
import com.duke.carpark.dto.PersonWithCarsDto;
import io.swagger.v3.oas.annotations.Hidden;

public interface PersonService {

    public List<PersonDto> getAllPersons();

    public PersonDto getPersonById(UUID id);

    public PersonWithCarsDto getPersonWithCarsById(UUID id);

    public void addPerson(PersonDto newPerson);
}
