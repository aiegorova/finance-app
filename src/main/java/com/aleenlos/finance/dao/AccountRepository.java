package com.aleenlos.finance.dao;

import com.aleenlos.finance.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByPhoneNumberAndIsEnabledTrue(String phoneNumber);

}
