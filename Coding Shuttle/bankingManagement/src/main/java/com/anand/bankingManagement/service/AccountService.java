package com.anand.bankingManagement.service;

import com.anand.bankingManagement.dto.CreateAccountRequest;
import com.anand.bankingManagement.entity.Account;
import com.anand.bankingManagement.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(CreateAccountRequest request) {
        Account account = new Account(
                request.getHolderName(),
                request.getBalance()
        );

        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
