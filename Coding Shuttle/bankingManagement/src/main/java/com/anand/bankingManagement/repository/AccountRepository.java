package com.anand.bankingManagement.repository;

import com.anand.bankingManagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
