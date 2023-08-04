package org.rishmi5h.Service;

import org.rishmi5h.model.Accounts;
import org.rishmi5h.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsService {

    @Autowired
    AccountsRepository accountsRepository;


    // Create a new user
    public Accounts createAccount(Accounts user) {
        return accountsRepository.save(user);
    }

    // Get all users
    public List<Accounts> getAllAccounts() {
        return accountsRepository.findAll();
    }

    // Get user by ID
    public Optional<Accounts> getAccountById(Long userId) {
        return accountsRepository.findById(userId);
    }

    // Update user
    public Accounts updateAccount(Long userId, Accounts userDetails) {
        Optional<Accounts> user = accountsRepository.findById(userId);
        if (user.isPresent()) {
            Accounts existingUser = user.get();
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setEmail(userDetails.getEmail());
            return accountsRepository.save(existingUser);
        }
        return null;
    }

    // Delete all users
    public void deleteAllAccounts() {
        accountsRepository.deleteAll();
    }

    // Delete user
    public void deleteAccount(Long userId) {
        accountsRepository.deleteById(userId);
    }
}
