package com.aleenlos.finance.mapper;

import com.aleenlos.finance.dto.AccountDTO;
import com.aleenlos.finance.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends EntityMapper<AccountDTO, Account> {
}
