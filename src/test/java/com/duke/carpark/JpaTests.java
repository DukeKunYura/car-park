package com.duke.carpark;

import com.duke.carpark.entity.Account;
import com.duke.carpark.entity.Car;
import com.duke.carpark.entity.Detail;
import com.duke.carpark.entity.Person;
import com.duke.carpark.repository.CarRepository;
import com.duke.carpark.repository.DetailRepository;
import com.duke.carpark.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class JpaTests {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    DetailRepository detailRepository;
    private UUID personId;
    private UUID carId;

    @PostConstruct
    void addPersonalCarsAndDetails() {
        Person person = new Person();
        person.setPassportNumber("808080");
        person.setFirstName("Claude");
        person.setSurname("Monet");
        person = personRepository.save(person);
        personId = person.getId();

        Car renault = new Car();
        renault.setBrand("Renault");
        renault.setNumber("8888");
        renault.setVin("9111");
        renault = carRepository.save(renault);
        carId = renault.getId();

        Car chevrolet = new Car();
        chevrolet.setBrand("Chevrolet");
        chevrolet.setNumber("5050");
        chevrolet.setVin("9222");
        chevrolet = carRepository.save(chevrolet);

        Detail engine = new Detail();
        engine.setSerialNumber("E-001");
        engine.setTitle("engine");
        detailRepository.save(engine);

        Detail battery = new Detail();
        battery.setSerialNumber("B-002");
        battery.setTitle("battery");
        detailRepository.save(battery);

        renault.addDetail(engine);
        renault.addDetail(battery);
        carRepository.save(renault);

        person.addCar(chevrolet);
        person.addCar(renault);
        personRepository.save(person);

        {
            Account account = new Account();
            account.setTitle("First account");
            account.setNumber("ABCD-1");
            account.setScore(new BigDecimal(0.01));
            person.addAccount(account);
        }
        {
            Account account = new Account();
            account.setTitle("Second account");
            account.setNumber("ABCD-2");
            account.setScore(new BigDecimal(10.00));
            person.addAccount(account);
        }
        personRepository.save(person);
    }

    @Test
    @Rollback(value = false)
    void checkAddedCars() {
        Person person = personRepository.findById(personId).orElseThrow();
        assertEquals(2, person.getCars().size());
        assertEquals(2, person.getAccounts().size());
        Car car = carRepository.findCarById(carId);
        assertEquals(2, car.getDetails().size());
    }

}