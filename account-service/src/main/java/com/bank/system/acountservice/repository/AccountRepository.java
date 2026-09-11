package com.bank.system.acountservice.repository;

import com.bank.system.acountservice.dto.AccountResponse;
import com.bank.system.acountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByAccountNumber(Long accountNumber);

    @Query(value = "SELECT * FROM account WHERE account_number = :accountNumber", nativeQuery = true)
    Optional<Account> findByAccountNumber(@Param("accountNumber") Long accountNumber);
}
