package com.aleenlos.finance.unit.mapper;

import com.aleenlos.finance.dto.AccountDTO;
import com.aleenlos.finance.mapper.AccountMapper;
import com.aleenlos.finance.mapper.AccountMapperImpl;
import com.aleenlos.finance.model.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.aleenlos.finance.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {AccountMapperImpl.class})
class AccountMapperTest {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    void toEntity_correctDTO_equals() {
        Account expected = Account.builder()
                .id(CORRECT_ID)
                .firstName("")
                .lastName("")
                .phoneNumber(CORRECT_PHONE_NUMBER)
                .build();
        AccountDTO dto = new AccountDTO(CORRECT_ID, "", "", CORRECT_PHONE_NUMBER);
        Account actual = accountMapper.toEntity(dto);
        assertEquals(expected, actual);
    }

    @Test
    void toDTO_correctAccount_equals() {
        AccountDTO expected = new AccountDTO(CORRECT_ID, "", "", CORRECT_PHONE_NUMBER);
        Account account = Account.builder()
                .id(CORRECT_ID)
                .firstName("")
                .lastName("")
                .phoneNumber(CORRECT_PHONE_NUMBER)
                .build();
        AccountDTO actual = accountMapper.toDTO(account);
        assertEquals(expected, actual);
    }

}
