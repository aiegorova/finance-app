package com.aleenlos.finance.service;

import com.aleenlos.finance.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryDTO> findAll();
    Optional<CategoryDTO> findById(Long id);
    CategoryDTO save(CategoryDTO category);

}
