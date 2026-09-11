package com.bank.system.accountservice.service;

import com.bank.system.accountservice.dto.AccountCreateRequest;
import com.bank.system.accountservice.dto.AccountResponse;
import com.bank.system.accountservice.entity.AccountStatus;

import java.util.List;

public interface AccountService {
    AccountResponse createAccount(AccountCreateRequest request);

    AccountResponse getAccountByAccountNumber(Long id);

    List<AccountResponse> getAllAccounts();

    List<AccountResponse> getAccountsByCustomer(Long customerId);

    AccountResponse updateAccountStatus(Long id, AccountStatus status);
}
