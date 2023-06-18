package com.duke.carpark.services.impl;

import com.duke.carpark.dto.PersonWithAccountsDto;
import com.duke.carpark.entity.Account;
import com.duke.carpark.entity.Person;
import com.duke.carpark.mappers.PersonMapper;
import com.duke.carpark.repository.AccountRepository;
import com.duke.carpark.repository.PersonRepository;
import com.duke.carpark.services.PersonAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonAccountServiceImpl implements PersonAccountService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final AccountRepository accountRepository;

    @Override
    public PersonWithAccountsDto addPersonAccount(UUID personId, UUID accountId) {
        Person person = personRepository.findPersonById(personId);
        Account account = accountRepository.findAccountById(accountId);
        person.addAccount(account);
        personRepository.save(person);

        return personMapper.toDtoWithAccounts(person);
    };

    @Override
    public PersonWithAccountsDto removePersonAccount(UUID personId, UUID accountId) {
        Person person = personRepository.findPersonById(personId);
        Account account = accountRepository.findAccountById(accountId);
        person.removeAccount(account);
        personRepository.save(person);

        return personMapper.toDtoWithAccounts(person);
    };
}
