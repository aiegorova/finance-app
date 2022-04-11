package com.aleenlos.finance.model;

import com.aleenlos.finance.enums.CategoryType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryType type;

}
