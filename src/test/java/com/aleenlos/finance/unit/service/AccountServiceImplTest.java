package com.aleenlos.finance.unit.service;

import com.aleenlos.finance.dao.AccountRepository;
import com.aleenlos.finance.dto.AccountDTO;
import com.aleenlos.finance.mapper.AccountMapper;
import com.aleenlos.finance.model.Account;
import com.aleenlos.finance.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.aleenlos.finance.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Spy
    private AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    void findAll_listReturned() {
        List<AccountDTO> expected = new ArrayList<>();
        expected.add(new AccountDTO(CORRECT_ID, "", "", CORRECT_PHONE_NUMBER));
        List<Account> accounts = expected.stream()
                .map(accountMapper::toEntity)
                .collect(Collectors.toList());
        when(accountRepository.findAll()).thenReturn(accounts);
        List<AccountDTO> actual = accountService.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void findById_correctId_accountReturned() {
        Optional<AccountDTO> expected = Optional.of(new AccountDTO(CORRECT_ID, "", "", CORRECT_PHONE_NUMBER));
        Optional<Account> account = expected.map(accountMapper::toEntity);
        Mockito.when(accountRepository.findById(CORRECT_ID)).thenReturn(account);
        Optional<AccountDTO> actual = accountService.findById(CORRECT_ID);
        assertEquals(expected, actual);
    }

    @Test
    void findByPhoneNumber_correctPhoneNumber_accountReturned() {
        Optional<AccountDTO> expected = Optional.of(new AccountDTO(CORRECT_ID, "", "", CORRECT_PHONE_NUMBER));
        Optional<Account> account = expected.map(accountMapper::toEntity);
        Mockito.when(accountRepository.findByPhoneNumberAndIsEnabledTrue(CORRECT_PHONE_NUMBER)).thenReturn(account);
        Optional<AccountDTO> actual = accountService.findByPhoneNumber(CORRECT_PHONE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    void save_correctAccount_accountReturned() {
        AccountDTO expected = new AccountDTO(CORRECT_ID, "", "", CORRECT_PHONE_NUMBER);
        Account account = accountMapper.toEntity(expected);
        Mockito.when(accountRepository.saveAndFlush(account)).thenReturn(account);
        AccountDTO actual = accountService.save(expected);
        assertEquals(expected, actual);
    }

}
