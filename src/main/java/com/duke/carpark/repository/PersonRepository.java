package com.duke.carpark.repository;

import com.duke.carpark.entity.Person;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Hidden
@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
}
