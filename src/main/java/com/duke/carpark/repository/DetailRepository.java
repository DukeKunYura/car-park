package com.duke.carpark.repository;

import com.duke.carpark.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DetailRepository extends JpaRepository<Detail, UUID> {
}
