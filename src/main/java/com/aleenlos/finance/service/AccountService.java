package com.aleenlos.finance.service;

import com.aleenlos.finance.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> findAll();
    Optional<Account> findById(Long id);
    Optional<Account> findByPhoneNumber(String phoneNumber);
    Account save(Account account);

}
