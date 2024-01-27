package ru.netology.moneytransferservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.netology.moneytransferservice.constants.StatusOfTransfer;

import java.io.Serializable;

@Getter
@ToString
public class Transfer implements Serializable {
    private final String operationId;

    @JsonIgnore
    private final String cardNumberTo;

    @JsonIgnore
    private final String cardNumberFrom;

    @JsonIgnore
    private final Amount amount;

    @JsonIgnore
    private final String code;

    @Setter
    @JsonIgnore
    private StatusOfTransfer status = StatusOfTransfer.NEW;

    public Transfer(String operationId, String code, String cardNumberFrom, String cardNumberTo, Amount amount) {
        this.operationId = operationId;
        this.code = code;
        this.cardNumberFrom = cardNumberFrom;
        this.cardNumberTo = cardNumberTo;
        this.amount = amount;
    }
}
