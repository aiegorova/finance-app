package com.aleenlos.finance.controller;

import com.aleenlos.finance.dto.CategoryDTO;
import com.aleenlos.finance.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> findAll() {
        return categoryService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<CategoryDTO> findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public CategoryDTO save(@RequestBody CategoryDTO category) {
        return categoryService.save(category);
    }

    @PutMapping
    public CategoryDTO update(@RequestBody CategoryDTO category) {
        return categoryService.save(category);
    }

}
