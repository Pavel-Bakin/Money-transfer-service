package ru.netology.moneytransferservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.moneytransferservice.model.DataOfTransfer;
import ru.netology.moneytransferservice.model.Transfer;
import ru.netology.moneytransferservice.service.TransferService;

@RestController
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public Transfer transfer(@RequestBody DataOfTransfer dataOfTransfer) {
        return transferService.createTransfer(dataOfTransfer);
    }
}

