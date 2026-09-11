package com.bank.system.accountservice.controller;

import com.bank.system.accountservice.dto.AccountCreateRequest;
import com.bank.system.accountservice.dto.AccountResponse;
import com.bank.system.accountservice.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/createAccount")
    public AccountResponse createAccount(@RequestBody AccountCreateRequest createRequest) {
        return accountService.createAccount(createRequest);
    }

    @GetMapping("/{accountNumber}")
    public AccountResponse getAccountByAccountNumber(@PathVariable("accountNumber") Long accountNumber) {
        return accountService.getAccountByAccountNumber(accountNumber);
    }


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
}
