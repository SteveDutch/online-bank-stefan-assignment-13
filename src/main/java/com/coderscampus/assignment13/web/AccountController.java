package com.coderscampus.assignment13.web;

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
    public String showNewAcount(ModelMap model, Account account) {
        model.put("account", account);
        return "account";
    }

    @PostMapping("/users/{userId}/accounts")
    public String addAccount(Account account, @PathVariable Long userId) {

        User user = userService.findById(userId);
        account = accountService.addAccount(account, user);
        return "redirect:/users/{userId}";
    }

    @GetMapping("/users/{userId}/accounts/{accountId}")
    public String getAccountsForUser(ModelMap model, @PathVariable Long userId,
            @PathVariable Long accountId) {
        Account account = accountService.findById(accountId);
        model.put("account", account);
        return "account"; // + user.getUserId() + "accounts" +accountId;
    }

    @PostMapping("/users/{userId}/accounts/{accountId}")
    public String changeAccountName(Account account) {

        accountService.saveAccount(account);
        return "redirect:/users/{userId}";
    }

}
