package com.duke.carpark.services.impl;

import com.duke.carpark.dto.PersonDto;
import com.duke.carpark.dto.PersonWithCarsDto;
import com.duke.carpark.dto.PersonWithoutIdDto;
import com.duke.carpark.entity.Person;
import com.duke.carpark.filters.PersonFilter;
import com.duke.carpark.mappers.PersonMapper;
import com.duke.carpark.repository.PersonRepository;
import com.duke.carpark.services.PersonService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> personsListDto = new ArrayList<>();
        for (Person person : personList) {
            personsListDto.add(personMapper.toDto(person));
        }
        return personsListDto;
    }

    @Override
    public List<PersonDto> getPersonsByFilter(PersonFilter filter) {
        List<Person> persons = personRepository.findPersonsByFilter(filter);
        return personMapper.toDtoPersonsList(persons);
    }

    @Override
    public PersonDto getPersonById(UUID id) {
        Person person = personRepository.findById(id).orElseThrow();
        return personMapper.toDto(person);
    }

    @Override
    public PersonWithCarsDto getPersonWithCarsById(UUID id) {
        Person person = personRepository.findPersonById(id);
        return personMapper.toDtoWithCars(person);
    }

    @Override
    public PersonDto addPerson(PersonWithoutIdDto dto) {
        Person person = personMapper.toEntityWithoutId(dto);
        Person newPerson = personRepository.save(person);
        return personMapper.toDto(newPerson);
    }
}
