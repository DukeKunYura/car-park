package com.duke.carpark.services.impl;

import com.duke.carpark.dto.AccountDto;
import com.duke.carpark.entity.Account;
import com.duke.carpark.mappers.AccountMapper;
import com.duke.carpark.repository.AccountRepository;
import com.duke.carpark.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();
        return accountMapper.toDtoAccountsList(accountList);
    }

    @Override
    public AccountDto getAccountById(UUID id) {
        Account account = accountRepository.findAccountById(id);
        return accountMapper.toDto(account);
    }

    @Override
    public AccountDto addAccount(AccountDto dto) {
        Account account = accountMapper.toEntity(dto);
        Account newAccount = accountRepository.save(account);
        return accountMapper.toDto(newAccount);
    }
}
