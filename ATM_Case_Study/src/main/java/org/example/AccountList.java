package org.example;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    List<Account> userAccounts;
    List<Account> administratorAccounts;

    public AccountList() {
        userAccounts = new ArrayList<>();
        administratorAccounts = new ArrayList<>();
    }

    public void addUser(Account account) {
        userAccounts.add(account);
    }
    public void addAdministrator(Account account) {
        administratorAccounts.add(account);
    }
    public void RemoveUser(Account account) {
        userAccounts.remove(account);
    }
    public void RemoveAdministrator(Account account) {
        administratorAccounts.remove(account);
    }

    public List<Account> getUserAccounts() {
        return userAccounts;
    }

    public List<Account> getAdministratorAccounts() {
        return administratorAccounts;
    }
}
