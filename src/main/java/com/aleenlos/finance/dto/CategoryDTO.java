package com.aleenlos.finance.dto;

import com.aleenlos.finance.enums.CategoryType;
import lombok.Value;

@Value
public class CategoryDTO {

    Long id;
    String name;
    CategoryType type;

}
