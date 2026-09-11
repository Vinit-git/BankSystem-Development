package com.bank.system.acountservice.dto;

import com.bank.system.acountservice.entity.AccountType;

public class AccountCreateRequest {
    private Long customerId;
    private AccountType accountType;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
