package ru.netology.moneytransferservice.model;

import lombok.Data;

@Data
public class Amount {
    private int value;
    private String currency;
}
