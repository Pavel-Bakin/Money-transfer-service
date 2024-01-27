package ru.netology.moneytransferservice.service;

import org.springframework.stereotype.Component;
import ru.netology.moneytransferservice.constants.StatusOfTransfer;
import ru.netology.moneytransferservice.model.Amount;
import ru.netology.moneytransferservice.model.Transfer;

@Component
public class TransferBuilder {
    private String cardNumberTo;
    private String cardNumberFrom;
    private String operationId;
    private String code;
    private Amount amount;
    private StatusOfTransfer status;

    public TransferBuilder() {
    }

    public TransferBuilder addOperationId(String operationId) {
        this.operationId = operationId;
        return this;
    }

    public TransferBuilder addCode(String code) {
        this.code = code;
        return this;
    }

    public TransferBuilder addCardNumberTo(String cardNumberTo) {
        this.cardNumberTo = cardNumberTo;
        return this;
    }

    public TransferBuilder addCardNumberFrom(String cardNumberFrom) {
        this.cardNumberFrom = cardNumberFrom;
        return this;
    }

    public TransferBuilder addAmount(Amount amount) {
        this.amount = amount;
        return this;
    }

    public TransferBuilder addStatus(StatusOfTransfer status) {
        this.status = status;
        return this;
    }

    public Transfer build() {
        return new Transfer(operationId, code, cardNumberFrom, cardNumberTo, amount);
    }
}
