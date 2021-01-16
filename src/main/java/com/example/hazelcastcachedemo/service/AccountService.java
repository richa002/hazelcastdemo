package com.example.hazelcastcachedemo.service;

import com.example.hazelcastcachedemo.model.UserAccount;

public interface AccountService {
    UserAccount findByAccountNumber(String accountNumber);
    void save(UserAccount user);
    void edit(UserAccount user);
    void deleteByAccountNumber(String accountNumber);
}
