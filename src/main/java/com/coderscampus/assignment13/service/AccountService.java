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
    private UserService userService;
    
    @Autowired
    private UserRepository userRepo;
    
    public Account findById(Long accountId) {
        Optional<Account> accountOpt = accountRepo.findById(accountId);
        return accountOpt.orElse(new Account());
    }

    public Account saveAccount(Account account) {
        // TODO Auto-generated method stub
        System.out.println(account + "(...from Start of  AccountService.saveAccount()" );

        return accountRepo.save(account);
    }
    
    public Account addAccount (Account account, User user) {
        
        if (account.getAccountId() == null) {
            System.out.println("account name = " + account.getAccountName() +
                    "  helle frm null clause in addAccount@AccountService/" + AccountService.class);
            
            
          
//           User user =new User();
//           user = userService.findById(userId);
//           System.out.println(user);
            accountRepo.save(account);
            
           System.out.println(account + "from end null clause @" +AccountService.class);
        }
        return account;
    }

}
