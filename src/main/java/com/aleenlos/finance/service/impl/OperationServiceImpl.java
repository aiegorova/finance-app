package com.aleenlos.finance.service.impl;

import com.aleenlos.finance.dao.OperationRepository;
import com.aleenlos.finance.model.Operation;
import com.aleenlos.finance.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;

    @Override
    public List<Operation> findAll() {
        return operationRepository.findAll();
    }

    @Override
    public Optional<Operation> findById(Long id) {
        return operationRepository.findById(id);
    }

    @Override
    public Operation save(Operation operation) {
        return operationRepository.saveAndFlush(operation);
    }

}
