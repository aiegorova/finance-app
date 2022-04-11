package com.aleenlos.finance.unit.service;

import com.aleenlos.finance.dao.AccountRepository;
import com.aleenlos.finance.model.Account;
import com.aleenlos.finance.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.aleenlos.finance.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    void findAll_listReturned() {
        List<Account> expected = new ArrayList<>();
        expected.add(new Account());
        when(accountRepository.findAll()).thenReturn(expected);
        List<Account> actual = accountService.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void findById_correctId_accountReturned() {
        Optional<Account> expected = Optional.of(new Account());
        Mockito.when(accountRepository.findById(CORRECT_ID)).thenReturn(expected);
        Optional<Account> actual = accountService.findById(CORRECT_ID);
        assertEquals(expected, actual);
    }

    @Test
    void findByPhoneNumber_correctPhoneNumber_accountReturned() {
        Optional<Account> expected = Optional.of(new Account());
        Mockito.when(accountRepository.findByPhoneNumberAndIsEnabledTrue(CORRECT_PHONE_NUMBER)).thenReturn(expected);
        Optional<Account> actual = accountService.findByPhoneNumber(CORRECT_PHONE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    void save_correctAccount_accountReturned() {
        Account expected = new Account();
        Mockito.when(accountRepository.saveAndFlush(expected)).thenReturn(expected);
        Account actual = accountService.save(expected);
        assertEquals(expected, actual);
    }

}
