package com.aleenlos.finance.unit.mapper;

import com.aleenlos.finance.dto.CategoryDTO;
import com.aleenlos.finance.enums.CategoryType;
import com.aleenlos.finance.mapper.CategoryMapper;
import com.aleenlos.finance.mapper.CategoryMapperImpl;
import com.aleenlos.finance.model.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.aleenlos.finance.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {CategoryMapperImpl.class})
class CategoryMapperTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void toEntity_correctDTO_equals() {
        Category expected = Category.builder()
                .id(CORRECT_ID)
                .name("")
                .type(CategoryType.INCOME)
                .build();
        CategoryDTO dto = new CategoryDTO(CORRECT_ID, "", CategoryType.INCOME);
        Category actual = categoryMapper.toEntity(dto);
        assertEquals(expected, actual);
    }

    @Test
    void toDTO_correctCategory_equals() {
        CategoryDTO expected = new CategoryDTO(CORRECT_ID, "", CategoryType.INCOME);
        Category account = Category.builder()
                .id(CORRECT_ID)
                .name("")
                .type(CategoryType.INCOME)
                .build();
        CategoryDTO actual = categoryMapper.toDTO(account);
        assertEquals(expected, actual);
    }

}
