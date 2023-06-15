package com.duke.carpark.repository;

import com.duke.carpark.entity.Account;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
@Hidden
public interface AccountRepository extends JpaRepository<Account, UUID> {
}
