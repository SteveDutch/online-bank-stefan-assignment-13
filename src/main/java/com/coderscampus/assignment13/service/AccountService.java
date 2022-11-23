package com.coderscampus.assignment13.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.repository.AccountRepository;
import com.coderscampus.assignment13.repository.UserRepository;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepo;
    
    @Autowired
    private UserRepository userRepo;
    
    public Account findById(Long accountId) {
        Optional<Account> accountOpt = accountRepo.findById(accountId);
        return accountOpt.orElse(new Account());
    }

    public Account saveAccount(Account account) {
        // TODO Auto-generated method stub
        return accountRepo.save(account);
    }
    
    

}
