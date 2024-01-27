package ru.netology.moneytransferservice.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.netology.moneytransferservice.model.Account;
import ru.netology.moneytransferservice.repository.AccountRepository;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AccountRepositoryTest {

    @Mock
    private AccountRepository accountRepositoryMock;

    public AccountRepositoryTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAccountForNumber() {
        // Arrange
        Account account1 = new Account("6452132146731", "78913", "555");
        Account account2 = new Account("5431247532823", "569012", "909");
        when(accountRepositoryMock.getAccountForNumber("6452132146731")).thenReturn(Optional.of(account1));
        when(accountRepositoryMock.getAccountForNumber("5431247532823")).thenReturn(Optional.of(account2));

        // Act
        Optional<Account> foundAccount1 = accountRepositoryMock.getAccountForNumber("6452132146731");
        Optional<Account> foundAccount2 = accountRepositoryMock.getAccountForNumber("5431247532823");
        Optional<Account> notFoundAccount = accountRepositoryMock.getAccountForNumber("1234567890123456");

        // Assert
        assertEquals(account1, foundAccount1.get());
        assertEquals(account2, foundAccount2.get());
        assertEquals(Optional.empty(), notFoundAccount);
        verify(accountRepositoryMock, times(3)).getAccountForNumber(anyString());
    }
}