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
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/users/{userId}/accounts")
    public String showNewAcount (ModelMap model,Account account) {
        model.put("account", account);
        return "account";
    }
    
    @PostMapping("/users/{userId}/accounts")
    public String addAccount (Account account, @PathVariable Long userId) {
        
      
        System.out.println("Long userId= " + userId);
    
        System.out.println(userService.findById(userId));
        User user = userService.findById(userId);
        System.out.println(account + " (... from PostMapping(\"/users/{userId}/accounts\")");
        //model.put("account", newAccount(null, null));
        account.getUsers().add(user);
        user.getAccounts().add(account);
        account = accountService.addAccount(account, user);
        
        System.out.println("@PostMapping -> user: "+ user + "account: " + account);
        return "redirect:/users/{userId}";
        //User user = userService.findById(user{

    }
    
        
    
    @GetMapping("/users/{userId}/accounts/{accountId}")
    public String getAccountsForUser (ModelMap model, @PathVariable Long userId, 
                @PathVariable Long accountId) {
        //User user = userService.findById(userId);
        Account account = accountService.findById(accountId);
        //model.put("user", user);
        model.put("account", account);
        System.out.println(account + "       from AccounControllerGetMpping getAccountsForUser line 39" );
        return "account"; // + user.getUserId() + "accounts" +accountId;        
    }
    
    @PostMapping("/users/{userId}/accounts/{accountId}")
    public String changeAccountName (Account account) {
   

        accountService.saveAccount(account);


        return "redirect:/users/{userId}/accounts/{accountId}";
    }

    
}
