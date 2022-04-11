package com.aleenlos.finance.unit.mapper;

import com.aleenlos.finance.dto.AccountDTO;
import com.aleenlos.finance.dto.CategoryDTO;
import com.aleenlos.finance.dto.OperationDTO;
import com.aleenlos.finance.enums.CategoryType;
import com.aleenlos.finance.mapper.OperationMapper;
import com.aleenlos.finance.mapper.OperationMapperImpl;
import com.aleenlos.finance.model.Account;
import com.aleenlos.finance.model.Category;
import com.aleenlos.finance.model.Operation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.aleenlos.finance.utils.Constants.CORRECT_AMOUNT;
import static com.aleenlos.finance.utils.Constants.CORRECT_ID;
import static com.aleenlos.finance.utils.Constants.CORRECT_PHONE_NUMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {OperationMapperImpl.class})
class OperationMapperTest {

    @Autowired
    private OperationMapper operationMapper;

    @Test
    void toEntity_correctDTO_equals() {
        Account account = Account.builder()
                .id(CORRECT_ID)
                .firstName("")
                .lastName("")
                .phoneNumber(CORRECT_PHONE_NUMBER)
                .build();
        Category category = Category.builder()
                .id(CORRECT_ID)
                .name("")
                .type(CategoryType.INCOME)
                .build();
        Operation expected = Operation.builder()
                .id(CORRECT_ID)
                .account(account)
                .category(category)
                .amount(CORRECT_AMOUNT)
                .build();
        AccountDTO accountDTO = new AccountDTO(CORRECT_ID, "", "", CORRECT_PHONE_NUMBER);
        CategoryDTO categoryDTO = new CategoryDTO(CORRECT_ID, "", CategoryType.INCOME);
        OperationDTO dto = new OperationDTO(CORRECT_ID, accountDTO, categoryDTO, CORRECT_AMOUNT);
        Operation actual = operationMapper.toEntity(dto);
        assertEquals(expected, actual);
    }

    @Test
    void toDTO_correctCategory_equals() {
        AccountDTO accountDTO = new AccountDTO(CORRECT_ID, "", "", CORRECT_PHONE_NUMBER);
        CategoryDTO categoryDTO = new CategoryDTO(CORRECT_ID, "", CategoryType.INCOME);
        OperationDTO expected = new OperationDTO(CORRECT_ID, accountDTO, categoryDTO, CORRECT_AMOUNT);
        Account account = Account.builder()
                .id(CORRECT_ID)
                .firstName("")
                .lastName("")
                .phoneNumber(CORRECT_PHONE_NUMBER)
                .build();
        Category category = Category.builder()
                .id(CORRECT_ID)
                .name("")
                .type(CategoryType.INCOME)
                .build();
        Operation operation = Operation.builder()
                .id(CORRECT_ID)
                .account(account)
                .category(category)
                .amount(CORRECT_AMOUNT)
                .build();
        OperationDTO actual = operationMapper.toDTO(operation);
        assertEquals(expected, actual);
    }

}
