package ru.netology.moneytransferservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.moneytransferservice.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepository {

    private List<Account> accounts;

    public AccountRepository() {
        accounts = new ArrayList<>();
        accounts.add(new Account("6452132146731", "78913", "555"));
        accounts.add(new Account("5431247532823", "569012", "909"));
    }

    public Optional<Account> getAccountForNumber(String number) {
        for (Account account : accounts) {
            if (account.getNumber().equals(number)) {
                return Optional.of(account);
            }
        }

        return Optional.empty();
    }
}
