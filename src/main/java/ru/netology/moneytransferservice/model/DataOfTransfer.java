package ru.netology.moneytransferservice.model;

import lombok.Data;

@Data
public class DataOfTransfer {

    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardFromCVV;
    private String cardToNumber;
    private Amount amount;

}
