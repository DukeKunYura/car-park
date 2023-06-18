package com.duke.carpark.repository;

import com.duke.carpark.entity.Account;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Hidden
@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    Account findAccountById(UUID id);
}
