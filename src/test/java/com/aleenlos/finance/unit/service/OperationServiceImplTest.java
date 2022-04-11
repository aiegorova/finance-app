package com.aleenlos.finance.unit.service;

import com.aleenlos.finance.dao.OperationRepository;
import com.aleenlos.finance.dto.AccountDTO;
import com.aleenlos.finance.dto.CategoryDTO;
import com.aleenlos.finance.dto.OperationDTO;
import com.aleenlos.finance.enums.CategoryType;
import com.aleenlos.finance.mapper.OperationMapper;
import com.aleenlos.finance.model.Operation;
import com.aleenlos.finance.service.impl.OperationServiceImpl;
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
class OperationServiceImplTest {

    @Mock
    private OperationRepository categoryRepository;

    @Spy
    private OperationMapper operationMapper = Mappers.getMapper(OperationMapper.class);

    @InjectMocks
    private OperationServiceImpl categoryService;

    @Test
    void findAll_listReturned() {
        AccountDTO accountDTO = new AccountDTO(CORRECT_ID, "", "", CORRECT_PHONE_NUMBER);
        CategoryDTO categoryDTO = new CategoryDTO(CORRECT_ID, "", CategoryType.INCOME);
        List<OperationDTO> expected = new ArrayList<>();
        expected.add(new OperationDTO(CORRECT_ID, accountDTO, categoryDTO, CORRECT_AMOUNT));
        List<Operation> operations = expected.stream()
                .map(operationMapper::toEntity)
                .collect(Collectors.toList());
        when(categoryRepository.findAll()).thenReturn(operations);
        List<OperationDTO> actual = categoryService.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void findById_correctId_operationReturned() {
        AccountDTO accountDTO = new AccountDTO(CORRECT_ID, "", "", CORRECT_PHONE_NUMBER);
        CategoryDTO categoryDTO = new CategoryDTO(CORRECT_ID, "", CategoryType.INCOME);
        Optional<OperationDTO> expected = Optional.of(new OperationDTO(CORRECT_ID, accountDTO, categoryDTO, CORRECT_AMOUNT));
        Optional<Operation> operation = expected.map(operationMapper::toEntity);
        Mockito.when(categoryRepository.findById(CORRECT_ID)).thenReturn(operation);
        Optional<OperationDTO> actual = categoryService.findById(CORRECT_ID);
        assertEquals(expected, actual);
    }

    @Test
    void save_correctOperation_operationReturned() {
        AccountDTO accountDTO = new AccountDTO(CORRECT_ID, "", "", CORRECT_PHONE_NUMBER);
        CategoryDTO categoryDTO = new CategoryDTO(CORRECT_ID, "", CategoryType.INCOME);
        OperationDTO expected = new OperationDTO(CORRECT_ID, accountDTO, categoryDTO, CORRECT_AMOUNT);
        Operation operation = operationMapper.toEntity(expected);
        Mockito.when(categoryRepository.saveAndFlush(operation)).thenReturn(operation);
        OperationDTO actual = categoryService.save(expected);
        assertEquals(expected, actual);
    }

}
