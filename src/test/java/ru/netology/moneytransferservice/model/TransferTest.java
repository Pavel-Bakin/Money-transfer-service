package ru.netology.moneytransferservice.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.moneytransferservice.constants.StatusOfTransfer;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TransferTest {

    @InjectMocks
    private Transfer transfer;

    @Test
    void testTransferConstructorAndGetters() {
        String operationId = "123456789";
        String code = "987654";
        String cardNumberFrom = "1234";
        String cardNumberTo = "5678";
        Amount amount = new Amount();
        amount.setValue(100);
        amount.setCurrency("USD");
        StatusOfTransfer status = StatusOfTransfer.NEW;

        Transfer transfer = new Transfer(operationId, code, cardNumberFrom, cardNumberTo, amount);

        assertEquals(operationId, transfer.getOperationId());
        assertEquals(code, transfer.getCode());
        assertEquals(cardNumberFrom, transfer.getCardNumberFrom());
        assertEquals(cardNumberTo, transfer.getCardNumberTo());
        assertEquals(amount, transfer.getAmount());
        assertEquals(status, transfer.getStatus());
    }

    @Test
    void testSetterAndGetters() {
        StatusOfTransfer expectedStatus = StatusOfTransfer.COMPLETE;

        transfer.setStatus(expectedStatus);

        assertEquals(expectedStatus, transfer.getStatus());
    }
}
