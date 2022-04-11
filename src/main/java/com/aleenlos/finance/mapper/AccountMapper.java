package com.aleenlos.finance.mapper;

import com.aleenlos.finance.dto.AccountDTO;
import com.aleenlos.finance.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper extends EntityMapper<AccountDTO, Account> {

    @Override
    @Mapping(target = "isEnabled", constant = "true")
    Account toEntity(AccountDTO dto);

}
