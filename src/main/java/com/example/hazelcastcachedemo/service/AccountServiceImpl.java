package com.example.hazelcastcachedemo.service;

import com.example.hazelcastcachedemo.model.UserAccount;
import com.example.hazelcastcachedemo.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@CacheConfig(cacheNames = "accounts")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    @Cacheable(value = "accounts", key = "#accountNumber")
    public UserAccount findByAccountNumber(String accountNumber) {
      return   accountRepository.findByAccountNumber(accountNumber);
    }

    @Override

    public void save(UserAccount user) {
        accountRepository.save(user);
    }

    @Override
    @Transactional
    @CacheEvict(value = "accounts", key = "#accountNumber")
    public void deleteByAccountNumber(String accountNumber) {
         accountRepository.deleteByAccountNumber(accountNumber);

    }
    @Override
    @CachePut(value = "accounts", key = "#user.id")
    public void edit(UserAccount user) {
        accountRepository.save(user);
    }
}
