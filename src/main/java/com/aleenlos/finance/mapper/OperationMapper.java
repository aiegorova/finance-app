package com.aleenlos.finance.mapper;

import com.aleenlos.finance.dto.OperationDTO;
import com.aleenlos.finance.model.Operation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperationMapper extends EntityMapper<OperationDTO, Operation> {
}
