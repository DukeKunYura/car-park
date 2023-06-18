package com.duke.carpark.services;

import com.duke.carpark.dto.AccountDto;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    List<AccountDto> getAllAccounts();

    AccountDto getAccountById(UUID id);

    AccountDto addAccount(AccountDto dto);
}
