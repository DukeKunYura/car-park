package com.duke.carpark;

import com.duke.carpark.entity.Car;
import com.duke.carpark.entity.Person;
import com.duke.carpark.repository.CarRepository;
import com.duke.carpark.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class JpaTests {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    CarRepository carRepository;
    private UUID personId;

    @PostConstruct
    void addThreePersonalCar() {
        Person person = new Person();
        person.setPassportNumber("202020");
        person.setFirstName("Gustav");
        person.setSurname("Klimt");
        person = personRepository.save(person);
        personId = person.getId();

        {
            Car car = new Car();
            car.setBrand("Audi");
            car.setNumber("8888");
            car.setVin("9111");
            person.addCar(car);
        }
        {
            Car car = new Car();
            car.setBrand("Mercedes");
            car.setNumber("9000");
            car.setVin("9333");
            person.addCar(car);
        }
        {
            Car car = new Car();
            car.setBrand("Chevrolet");
            car.setNumber("5050");
            car.setVin("9222");
            person.addCar(car);
        }
        personRepository.save(person);
    }

    @Test
    @Rollback(value = false)
    void checkAddedCars() {
        Person person = personRepository.findById(personId).orElseThrow();
        person.getCars().size();
        System.out.println("person.getCars().size() = " + person.getCars().size());
        assertEquals(3, person.getCars().size());
    }
}