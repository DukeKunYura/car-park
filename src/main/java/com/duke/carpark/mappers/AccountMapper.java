package com.duke.carpark.mappers;

import com.duke.carpark.dto.AccountDto;
import com.duke.carpark.dto.AccountWithoutIdDto;
import com.duke.carpark.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {
    public AccountDto toDto(Account account) {
        AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setNumber(account.getNumber());
        dto.setTitle(account.getTitle());
        dto.setScore(account.getScore());
        return dto;
    }

    public Account toEntity(AccountDto dto) {
        Account account = new Account();
        account.setId(dto.getId());
        account.setNumber(dto.getNumber());
        account.setTitle(dto.getTitle());
        account.setScore(dto.getScore());
        return account;
    }

    public Account toEntityWithoutId(AccountWithoutIdDto dto) {
        Account account = new Account();
        account.setNumber(dto.getNumber());
        account.setTitle(dto.getTitle());
        account.setScore(dto.getScore());
        return account;
    }

    public List<AccountDto> toDtoAccountsList(List<Account> accounts) {
        List<AccountDto> accountsListDto = new ArrayList<>();
        for (Account account : accounts) {
            accountsListDto.add(this.toDto(account));
        }
        return accountsListDto;
    }

}
