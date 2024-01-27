package ru.netology.moneytransferservice.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    private final String number;
    private final String validTiil;
    private final String cvv;
    private BigDecimal balance;
}