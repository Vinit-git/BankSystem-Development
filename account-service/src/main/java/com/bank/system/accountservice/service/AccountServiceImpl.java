package com.bank.system.accountservice.service;

import com.bank.system.accountservice.dto.AccountCreateRequest;
import com.bank.system.accountservice.dto.AccountResponse;
import com.bank.system.accountservice.entity.Account;
import com.bank.system.accountservice.entity.AccountStatus;
import com.bank.system.accountservice.mapper.AccountMapper;
import com.bank.system.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountResponse createAccount(AccountCreateRequest request) {
        Account account = new Account();
        account.setCustomerId(request.getCustomerId());
        account.setAccountType(request.getAccountType());
        account.setAccountNumber(generateAccountNumber());
        accountRepository.save(account);
        return accountMapper.toCreateAccountResponse(account);
    }

    private Long generateAccountNumber() {
        final SecureRandom random = new SecureRandom();
        long number = 1_000_000_000L + random.nextLong(9_000_000_000L);
        Long accountNumber = 50 + number;
        if (accountRepository.existsByAccountNumber(accountNumber)) {
           return generateAccountNumber();
        }
        return accountNumber;
    }

    @Override
    public AccountResponse getAccountByAccountNumber(Long accountNumber) {
        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
        return accountMapper.toCreateAccountResponse(account.get());
    }

    @Override
    public List<AccountResponse> getAllAccounts() {
        return List.of();
    }

    @Override
    public List<AccountResponse> getAccountsByCustomer(Long customerId) {
        return List.of();
    }

    @Override
    public AccountResponse updateAccountStatus(Long id, AccountStatus status) {
        return null;
    }

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }
}
