package com.anupam.bankingapi.controller;


import com.anupam.bankingapi.model.Account;
import com.anupam.bankingapi.model.TransactionRequest;
import com.anupam.bankingapi.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    AccountService accountService;

    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(@RequestParam(required = false) String type) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountService.getAllAccountDetails(type));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccountByNumber(@PathVariable Long accNumber) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountService.getAccountByNumber(accNumber));
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(account));
    }

    @PutMapping
    public ResponseEntity<Account> updateAccount(@Valid @RequestBody Account account, @PathVariable Long accNum) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(accountService.updateAccount(accNum, account));
    }

    @DeleteMapping
    public ResponseEntity<Account> deleteAccount(@PathVariable Long accNum) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountService.deleteAccount(accNum));
    }

    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable Long accNum, @Valid @RequestBody TransactionRequest request) {
        return ResponseEntity.ok(accountService.deposit(accNum, request.getAmount()));
    }

    @PostMapping("/{accountNumber}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable Long accNum, @Valid @RequestBody TransactionRequest request) {
        return ResponseEntity.ok(accountService.withdraw(accNum, request.getAmount()));
    }
}
