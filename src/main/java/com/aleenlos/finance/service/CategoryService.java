package com.aleenlos.finance.service;

import com.aleenlos.finance.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();
    Optional<Category> findById(Long id);
    Category save(Category category);

}
