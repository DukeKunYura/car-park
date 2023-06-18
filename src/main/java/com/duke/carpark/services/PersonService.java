package com.duke.carpark.services;

import java.util.List;
import java.util.UUID;

import com.duke.carpark.dto.PersonDto;
import com.duke.carpark.dto.PersonWithCarsDto;
import com.duke.carpark.dto.PersonWithoutIdDto;
import com.duke.carpark.filters.PersonFilter;

public interface PersonService {

    public List<PersonDto> getAllPersons();

    List<PersonDto> getPersonsByFilter(PersonFilter filter);

    public PersonDto getPersonById(UUID id);

    public PersonWithCarsDto getPersonWithCarsById(UUID id);

    public PersonDto addPerson(PersonWithoutIdDto newPerson);
}
