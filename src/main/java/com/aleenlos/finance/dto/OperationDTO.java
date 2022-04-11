package com.aleenlos.finance.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class OperationDTO {

    Long id;
    AccountDTO account;
    CategoryDTO category;
    BigDecimal amount;

}
