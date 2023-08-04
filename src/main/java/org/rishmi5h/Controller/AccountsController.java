package org.rishmi5h.Controller;


import org.rishmi5h.Service.AccountsService;
import org.rishmi5h.model.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    AccountsService accountsService;

    // Create a new user
    @PostMapping
    public Accounts createAccount(@RequestBody Accounts user) {
        return accountsService.createAccount(user);
    }

    // Get all users
    @GetMapping
    public List<Accounts> getAllAccounts() {
        return accountsService.getAllAccounts();
    }

    // Get user by ID
    @GetMapping("/{userID}")
    public Optional<Accounts> getAccountById(@PathVariable Long userID) {
        return accountsService.getAccountById(userID);
    }

    // Update user by ID
    @PutMapping("/{userID}")
    public Accounts updateAccount(@PathVariable Long userID, @RequestBody Accounts userDetails) {
        return accountsService.updateAccount(userID, userDetails);
    }

    // Delete all users
    @DeleteMapping
    public String deleteAllAccounts() {
        accountsService.deleteAllAccounts();
        return "All users have been deleted successfully.";
    }

    // Delete user by ID
    @DeleteMapping("/{userID}")
    public void deleteAccount(@PathVariable Long userID) {
        accountsService.deleteAccount(userID);
    }

}
