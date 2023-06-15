package com.duke.carpark.repository;

import com.duke.carpark.entity.Car;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
@Hidden
public interface CarRepository extends JpaRepository<Car, UUID> {
}
