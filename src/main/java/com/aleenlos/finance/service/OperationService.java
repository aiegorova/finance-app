package com.aleenlos.finance.service;

import com.aleenlos.finance.model.Operation;

import java.util.List;
import java.util.Optional;

public interface OperationService {

    List<Operation> findAll();
    Optional<Operation> findById(Long id);
    Operation save(Operation operation);

}
