package com.aleenlos.finance.service.impl;

import com.aleenlos.finance.dao.AccountRepository;
import com.aleenlos.finance.dto.AccountDTO;
import com.aleenlos.finance.mapper.AccountMapper;
import com.aleenlos.finance.model.Account;
import com.aleenlos.finance.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public List<AccountDTO> findAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(accountMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AccountDTO> findById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.map(accountMapper::toDTO);
    }

    @Override
    public Optional<AccountDTO> findByPhoneNumber(String phoneNumber) {
        Optional<Account> account = accountRepository.findByPhoneNumberAndIsEnabledTrue(phoneNumber);
        return account.map(accountMapper::toDTO);
    }

    @Override
    public AccountDTO save(AccountDTO dto) {
        Account account = accountMapper.toEntity(dto);
        accountRepository.saveAndFlush(account);
        return accountMapper.toDTO(account);
    }

}
