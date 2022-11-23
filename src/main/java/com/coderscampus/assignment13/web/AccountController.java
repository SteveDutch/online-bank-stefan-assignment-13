package com.coderscampus.assignment13.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.service.AccountService;
import com.coderscampus.assignment13.service.UserService;

@Controller
public class AccountController {
    
    @Autowired
    private AccountService accountService;
    
    private UserService userService;
    
    @GetMapping("/users/{userId}/accounts/{accountId}")
    public String getAccountsForUser (ModelMap model, @PathVariable Long userId, 
                @PathVariable Long accountId) {
        //User user = userService.findById(userId);
        Account account = accountService.findById(accountId);
        //model.put("user", user);
        model.put("account", account);
        System.out.println(account);
        return "account"; // + user.getUserId() + "accounts" +accountId;        
    }
    
    @PostMapping("/users/{userId}/accounts/{accountId}")
    public String saveUserAccountName (Account account) {
   

        accountService.saveAccount(account);


        return "redirect:/users/{userId}/accounts/{accountId}";
    }

    
}
