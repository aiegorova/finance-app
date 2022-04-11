package com.aleenlos.finance.service;

import com.aleenlos.finance.dto.AccountDTO;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<AccountDTO> findAll();
    Optional<AccountDTO> findById(Long id);
    Optional<AccountDTO> findByPhoneNumber(String phoneNumber);
    AccountDTO save(AccountDTO account);

}
