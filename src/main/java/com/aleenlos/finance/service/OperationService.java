package com.aleenlos.finance.service;

import com.aleenlos.finance.dto.OperationDTO;

import java.util.List;
import java.util.Optional;

public interface OperationService {

    List<OperationDTO> findAll();
    Optional<OperationDTO> findById(Long id);
    OperationDTO save(OperationDTO operation);

}
