package ru.netology.moneytransferservice.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.moneytransferservice.model.Transfer;

@RestController
public class ConfirmController {

    @PostMapping("/confirm")
    public Transfer confirm(@JsonProperty String operationId, @JsonProperty String code) {
        // Implement confirmation logic here
        return null;
    }
}
