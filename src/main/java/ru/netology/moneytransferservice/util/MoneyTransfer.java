package ru.netology.moneytransferservice.util;

import org.springframework.stereotype.Component;
import ru.netology.moneytransferservice.exception.ErrorTransfer;
import ru.netology.moneytransferservice.model.Account;
import ru.netology.moneytransferservice.model.Transfer;

@Component
public class MoneyTransfer {

    public boolean transferMoney(Account accountTo, Account accountFrom, Transfer transfer) throws ErrorTransfer {
        return true;
    }
}
