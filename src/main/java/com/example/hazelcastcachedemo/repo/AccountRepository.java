package com.example.hazelcastcachedemo.repo;

import com.example.hazelcastcachedemo.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<UserAccount,Long> {
    UserAccount findByAccountNumber(String accountNumber);

      void deleteByAccountNumber(String accountNumber);
}
