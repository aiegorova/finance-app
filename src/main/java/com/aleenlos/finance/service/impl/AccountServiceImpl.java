package com.aleenlos.finance.service.impl;

import com.aleenlos.finance.dao.AccountRepository;
import com.aleenlos.finance.model.Account;
import com.aleenlos.finance.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Optional<Account> findByPhoneNumber(String phoneNumber) {
        return accountRepository.findByPhoneNumberAndIsEnabledTrue(phoneNumber);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.saveAndFlush(account);
    }

}
