package com.aleenlos.finance.unit;

import com.aleenlos.finance.dao.OperationRepository;
import com.aleenlos.finance.model.Operation;
import com.aleenlos.finance.service.impl.OperationServiceImpl;
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
class OperationServiceImplTest {

    @Mock
    private OperationRepository categoryRepository;

    @InjectMocks
    private OperationServiceImpl categoryService;

    @Test
    void findAll_listReturned() {
        List<Operation> expected = new ArrayList<>();
        expected.add(new Operation());
        when(categoryRepository.findAll()).thenReturn(expected);
        List<Operation> actual = categoryService.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void findById_correctId_operationReturned() {
        Optional<Operation> expected = Optional.of(new Operation());
        Mockito.when(categoryRepository.findById(CORRECT_ID)).thenReturn(expected);
        Optional<Operation> actual = categoryService.findById(CORRECT_ID);
        assertEquals(expected, actual);
    }

    @Test
    void save_correctOperation_operationReturned() {
        Operation expected = new Operation();
        Mockito.when(categoryRepository.saveAndFlush(expected)).thenReturn(expected);
        Operation actual = categoryService.save(expected);
        assertEquals(expected, actual);
    }

}
