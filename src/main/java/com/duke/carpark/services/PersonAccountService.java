package com.duke.carpark.services;

import com.duke.carpark.dto.PersonWithAccountsDto;

import java.util.UUID;

public interface PersonAccountService {
    PersonWithAccountsDto addPersonAccount(UUID personId, UUID accountId);
}
