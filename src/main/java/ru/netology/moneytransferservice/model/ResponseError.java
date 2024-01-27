package ru.netology.moneytransferservice.model;

import lombok.Data;

@Data
public class ResponseError {
    private String message;
    private int id;

    public ResponseError(String message, int id) {
        this.message = message;
        this.id = id;
    }
}
