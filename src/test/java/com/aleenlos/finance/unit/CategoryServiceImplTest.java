package com.aleenlos.finance.unit;

import com.aleenlos.finance.dao.CategoryRepository;
import com.aleenlos.finance.model.Category;
import com.aleenlos.finance.service.impl.CategoryServiceImpl;
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
class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void findAll_listReturned() {
        List<Category> expected = new ArrayList<>();
        expected.add(new Category());
        when(categoryRepository.findAll()).thenReturn(expected);
        List<Category> actual = categoryService.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void findById_correct_accountReturned() {
        Optional<Category> expected = Optional.of(new Category());
        Mockito.when(categoryRepository.findById(CORRECT_ID)).thenReturn(expected);
        Optional<Category> actual = categoryService.findById(CORRECT_ID);
        assertEquals(expected, actual);
    }

    @Test
    void save_correctAccount_accountReturned() {
        Category expected = new Category();
        Mockito.when(categoryRepository.saveAndFlush(expected)).thenReturn(expected);
        Category actual = categoryService.save(expected);
        assertEquals(expected, actual);
    }

}
