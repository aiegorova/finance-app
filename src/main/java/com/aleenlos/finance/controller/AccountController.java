package com.aleenlos.finance.controller;

import com.aleenlos.finance.dto.AccountDTO;
import com.aleenlos.finance.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<AccountDTO> findAll() {
        return accountService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<AccountDTO> findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @PostMapping
    public AccountDTO save(AccountDTO account) {
        return accountService.save(account);
    }

    @PutMapping
    public AccountDTO update(AccountDTO account) {
        return accountService.save(account);
    }

}
