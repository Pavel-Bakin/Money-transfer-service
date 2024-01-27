package ru.netology.moneytransferservice.util;

import org.springframework.stereotype.Component;

@Component
public class GenerateCode {
    public String getCode() {
        return "1234567890";
    }
}
