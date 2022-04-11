package com.aleenlos.finance.controller;

import com.aleenlos.finance.dto.OperationDTO;
import com.aleenlos.finance.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/operation")
@RequiredArgsConstructor
public class OperationController {

    private final OperationService operationService;

    @GetMapping
    public List<OperationDTO> findAll() {
        return operationService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<OperationDTO> findById(@PathVariable Long id) {
        return operationService.findById(id);
    }

    @PostMapping
    public OperationDTO save(OperationDTO operation) {
        return operationService.save(operation);
    }

    @PutMapping
    public OperationDTO update(OperationDTO operation) {
        return operationService.save(operation);
    }

}
