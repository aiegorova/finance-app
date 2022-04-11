package com.aleenlos.finance.service.impl;

import com.aleenlos.finance.dao.CategoryRepository;
import com.aleenlos.finance.dto.CategoryDTO;
import com.aleenlos.finance.mapper.CategoryMapper;
import com.aleenlos.finance.model.Category;
import com.aleenlos.finance.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryDTO> findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(categoryMapper::toDTO);
    }

    @Override
    public CategoryDTO save(CategoryDTO dto) {
        Category category = categoryMapper.toEntity(dto);
        categoryRepository.saveAndFlush(category);
        return categoryMapper.toDTO(category);
    }

}
