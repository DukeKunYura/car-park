package com.duke.carpark.repository;

import com.duke.carpark.entity.Detail;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Hidden
@Repository
public interface DetailRepository extends JpaRepository<Detail, UUID> {
    Detail findDetailById(UUID id);
}
