package com.aleenlos.finance.unit.service;

import com.aleenlos.finance.dao.CategoryRepository;
import com.aleenlos.finance.dto.CategoryDTO;
import com.aleenlos.finance.enums.CategoryType;
import com.aleenlos.finance.mapper.CategoryMapper;
import com.aleenlos.finance.model.Category;
import com.aleenlos.finance.service.impl.CategoryServiceImpl;
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
class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Spy
    private CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void findAll_listReturned() {
        List<CategoryDTO> expected = new ArrayList<>();
        expected.add(new CategoryDTO(CORRECT_ID, "", CategoryType.INCOME));
        List<Category> categories = expected.stream()
                .map(categoryMapper::toEntity)
                .collect(Collectors.toList());
        when(categoryRepository.findAll()).thenReturn(categories);
        List<CategoryDTO> actual = categoryService.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void findById_correctId_categoryReturned() {
        Optional<CategoryDTO> expected = Optional.of(new CategoryDTO(CORRECT_ID, "", CategoryType.INCOME));
        Optional<Category> category = expected.map(categoryMapper::toEntity);
        Mockito.when(categoryRepository.findById(CORRECT_ID)).thenReturn(category);
        Optional<CategoryDTO> actual = categoryService.findById(CORRECT_ID);
        assertEquals(expected, actual);
    }

    @Test
    void save_correctCategory_categoryReturned() {
        CategoryDTO expected = new CategoryDTO(CORRECT_ID, "", CategoryType.INCOME);
        Category category = categoryMapper.toEntity(expected);
        Mockito.when(categoryRepository.saveAndFlush(category)).thenReturn(category);
        CategoryDTO actual = categoryService.save(expected);
        assertEquals(expected, actual);
    }

}
