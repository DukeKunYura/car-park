package com.duke.carpark.services.impl;

import com.duke.carpark.dto.PersonDto;
import com.duke.carpark.dto.PersonWithCarsDto;
import com.duke.carpark.entity.Person;
import com.duke.carpark.mappers.PersonMapper;
import com.duke.carpark.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public List<PersonDto> getAllPersons() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> personsListDto = new ArrayList<>();
        for (Person person : personList) {
            personsListDto.add(personMapper.toDto(person));
        }
        return personsListDto;
    }

    public PersonDto getPersonById(UUID id) {
        Person person = personRepository.findById(id).orElseThrow();
        return personMapper.toDto(person);
    }

    public PersonWithCarsDto getPersonWithCarsById(UUID id) {
        Person person = personRepository.findById(id).orElseThrow();
        return personMapper.toDtoWithCars(person);
    }

    public void addPerson(PersonDto dto) {
        Person person = personMapper.toEntity(dto);
        personRepository.save(person);
    }
}
