package com.bank.system.acountservice.service;

import com.bank.system.acountservice.dto.AccountCreateRequest;
import com.bank.system.acountservice.dto.AccountResponse;
import com.bank.system.acountservice.entity.AccountStatus;

import java.util.List;

public interface AccountService {
    AccountResponse createAccount(AccountCreateRequest request);

    AccountResponse getAccountByAccountNumber(Long id);

    List<AccountResponse> getAllAccounts();

    List<AccountResponse> getAccountsByCustomer(Long customerId);

    AccountResponse updateAccountStatus(Long id, AccountStatus status);
}
