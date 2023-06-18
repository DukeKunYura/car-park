package com.duke.carpark.mappers;

import com.duke.carpark.dto.PersonDto;
import com.duke.carpark.dto.PersonWithAccountsDto;
import com.duke.carpark.dto.PersonWithCarsDto;
import com.duke.carpark.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public PersonDto toDto(Person person) {
        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setPassportNumber(person.getPassportNumber());
        dto.setFirstName(person.getFirstName());
        dto.setSurname(person.getSurname());
        dto.setPatronymic(person.getPatronymic());
        dto.setBirthDate(person.getBirthDate());
        dto.setStartDrivingDate(person.getStartDrivingDate());
        dto.setDriverCategory(person.getDriverCategory());
        return dto;
    }

    public PersonWithCarsDto toDtoWithCars(Person person) {
        PersonWithCarsDto dto = new PersonWithCarsDto();
        dto.setId(person.getId());
        dto.setPassportNumber(person.getPassportNumber());
        dto.setFirstName(person.getFirstName());
        dto.setSurname(person.getSurname());
        dto.setPatronymic(person.getPatronymic());
        dto.setBirthDate(person.getBirthDate());
        dto.setStartDrivingDate(person.getStartDrivingDate());
        dto.setDriverCategory(person.getDriverCategory());
        CarMapper carMapper = new CarMapper();
        dto.setCars(carMapper.toDtoCarsList(person.getCars()));
        return dto;
    }

    public PersonWithAccountsDto toDtoWithAccounts(Person person) {
        PersonWithAccountsDto dto = new PersonWithAccountsDto();
        dto.setId(person.getId());
        dto.setPassportNumber(person.getPassportNumber());
        dto.setFirstName(person.getFirstName());
        dto.setSurname(person.getSurname());
        dto.setPatronymic(person.getPatronymic());
        dto.setBirthDate(person.getBirthDate());
        dto.setStartDrivingDate(person.getStartDrivingDate());
        dto.setDriverCategory(person.getDriverCategory());
        AccountMapper accountMapper = new AccountMapper();
        dto.setAccounts(accountMapper.toDtoAccountsList(person.getAccounts()));
        return dto;
    }

    public Person toEntity(PersonDto dto) {
        Person person = new Person();
        person.setId(dto.getId());
        person.setPassportNumber(dto.getPassportNumber());
        person.setFirstName(dto.getFirstName());
        person.setSurname(dto.getSurname());
        person.setPatronymic(dto.getPatronymic());
        person.setBirthDate(dto.getBirthDate());
        person.setStartDrivingDate(dto.getStartDrivingDate());
        person.setDriverCategory(dto.getDriverCategory());
        return person;
    }
}
