package com.anupam.bankingapi.service;


import com.anupam.bankingapi.exception.AccountNotFoundException;
import com.anupam.bankingapi.exception.InsufficientBalanceException;
import com.anupam.bankingapi.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    List<Account> accounts = new ArrayList<>();
    private Long nextAccountNumber = 1003L;

    public AccountService() {
        accounts.add(new Account(1001L, "Anupam", "anupam@gmail.com", "SAVINGS", 5000));
        accounts.add(new Account(1002L, "Anand", "anand@gmail.com", "CURRENT", 12000));
    }

    public List<Account> getAllAccountDetails(String type) {
        if(type == null) {
            return accounts;
        }

        return accounts.stream()
                .filter(account -> account.getAccountType().equalsIgnoreCase(type)).toList();
    }

    public Account getAccountByNumber(Long accountNumber) {
        return accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findFirst()
                .orElseThrow(() -> new AccountNotFoundException("Account not found: "+ accountNumber));
    }

    public Account createAccount(Account account) {
        account.setAccountNumber(nextAccountNumber++);
        accounts.add(account);
        return account;
    }

    public Account updateAccount(Long accountNumber, Account updatedAccount) {
        Account account = getAccountByNumber(accountNumber);
        account.setAccountType(updatedAccount.getAccountType());
        account.setBalance(updatedAccount.getBalance());
        account.setHolderName(updatedAccount.getHolderName());
        account.setEmail(updatedAccount.getEmail());
        return account;
    }

    public Account deleteAccount(Long accountNumber) {
        Account account = getAccountByNumber(accountNumber);
        accounts.remove(account);
        return account;
    }

    public Account deposit(Long accountNumber, double amount) {
        Account account = getAccountByNumber(accountNumber);

        account.setBalance(account.getBalance() + amount);

        return account;
    }

    public Account withdraw(Long accountNumber, double amount) {
        Account account = getAccountByNumber(accountNumber);

        if(account.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }

        account.setBalance(account.getBalance() - amount);
        return account;
    }
}
