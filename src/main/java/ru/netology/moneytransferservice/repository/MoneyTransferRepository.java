package ru.netology.moneytransferservice.repository;

import ru.netology.moneytransferservice.exception.ConfirmError;
import ru.netology.moneytransferservice.model.Transfer;

import java.util.Optional;

public interface MoneyTransferRepository {
    void addNewTransfer(Transfer transfer);

    Optional<Transfer> getTransfer(String operationId);

    Optional<Transfer> deleteTransfer(String operationId) throws ConfirmError;
}