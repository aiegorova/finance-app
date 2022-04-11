package com.aleenlos.finance.service.impl;

import com.aleenlos.finance.dao.OperationRepository;
import com.aleenlos.finance.dto.OperationDTO;
import com.aleenlos.finance.mapper.OperationMapper;
import com.aleenlos.finance.model.Operation;
import com.aleenlos.finance.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;
    private final OperationMapper operationMapper;

    @Override
    public List<OperationDTO> findAll() {
        List<Operation> operations = operationRepository.findAll();
        return operations.stream()
                .map(operationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OperationDTO> findById(Long id) {
        Optional<Operation> operation = operationRepository.findById(id);
        return operation.map(operationMapper::toDTO);
    }

    @Override
    public OperationDTO save(OperationDTO dto) {
        Operation operation = operationMapper.toEntity(dto);
        operationRepository.saveAndFlush(operation);
        return operationMapper.toDTO(operation);
    }

}
