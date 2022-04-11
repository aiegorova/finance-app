package com.aleenlos.finance.mapper;

import com.aleenlos.finance.dto.CategoryDTO;
import com.aleenlos.finance.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {
}
