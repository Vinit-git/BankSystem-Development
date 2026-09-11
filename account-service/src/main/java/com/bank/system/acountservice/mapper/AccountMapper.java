package com.bank.system.acountservice.mapper;

import com.bank.system.acountservice.dto.AccountResponse;
import com.bank.system.acountservice.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountResponse toCreateAccountResponse(Account account) {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(account.getId());
        accountResponse.setAccountNumber(account.getAccountNumber());
        accountResponse.setBalance(account.getBalance());
        accountResponse.setStatus(account.getStatus());
        accountResponse.setAccountType(account.getAccountType());
        accountResponse.setCustomerId(account.getCustomerId());
        accountResponse.setCreatedAt(account.getCreatedAt());
        return accountResponse;
    }
}
