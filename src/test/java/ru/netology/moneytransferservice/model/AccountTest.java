package ru.netology.moneytransferservice.model;

import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void testAccountCreation() {
        // Arrange
        String number = "1234567890123456";
        String validTill = "12/23";
        String cvv = "123";
        BigDecimal initialBalance = new BigDecimal("1000.00");

        // Act
        Account account = new Account(number, validTill, cvv);
        account.setBalance(initialBalance);

        // Assert
        assertEquals(number, account.getNumber());
        assertEquals(validTill, account.getValidTiil());
        assertEquals(cvv, account.getCvv());
        assertEquals(initialBalance, account.getBalance());
    }
}
