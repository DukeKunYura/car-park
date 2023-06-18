package com.duke.carpark.services;

import java.util.List;
import java.util.UUID;

import com.duke.carpark.dto.PersonDto;
import com.duke.carpark.dto.PersonWithCarsDto;
import com.duke.carpark.dto.PersonWithoutIdDto;

public interface PersonService {

    public List<PersonDto> getAllPersons();

    public PersonDto getPersonById(UUID id);

    public PersonWithCarsDto getPersonWithCarsById(UUID id);

    public PersonDto addPerson(PersonWithoutIdDto newPerson);
}
