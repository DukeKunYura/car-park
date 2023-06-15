package com.duke.carpark.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persons")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {
    @Id
    @Column(name = "person_id")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @EqualsAndHashCode.Include
    private UUID id;
    @Column(name = "passport_number")
    private String passportNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "start_driving_date")
    private LocalDate startDrivingDate;
    @Column(name = "driver_category")
    private String driverCategory;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Car> cars = new ArrayList<>();
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Account> accounts = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
        car.setPerson(this);
    }

    public void removeCar(Car car) {
        cars.remove(car);
        car.setPerson(null);
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.setPerson(this);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        account.setPerson(null);
    }
}
