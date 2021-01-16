package com.example.hazelcastcachedemo.controller;

import com.example.hazelcastcachedemo.model.UserAccount;
import com.example.hazelcastcachedemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;

    @GetMapping(path = { "/get/{accountNumber}" })
    public UserAccount getUser(@PathVariable("accountNumber") String accountNumber) {
        return accountService.findByAccountNumber(accountNumber);
    }

    @PostMapping("/add")
    public void createUser(@RequestBody UserAccount user) {
        accountService.save(user);
    }

    @DeleteMapping(path = { "/{accountNumber}" })
    public void deleteUser(@PathVariable("accountNumber") String accountNumber) {
        accountService.deleteByAccountNumber(accountNumber);
    }
    @PutMapping("/edit")
    public void editUser(@RequestBody UserAccount user) {
        accountService.edit(user);
    }


}
