package ru.netology.moneytransferservice.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.SerializationUtils;
import ru.netology.moneytransferservice.exception.ConfirmError;
import ru.netology.moneytransferservice.model.Transfer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MoneyTransferRepositoryStubImpl implements MoneyTransferRepository {

    private List<Transfer> transfers;

    public MoneyTransferRepositoryStubImpl() {
        transfers = new ArrayList<>();
    }

    @Override
    public void addNewTransfer(Transfer transfer) {
        transfers.add(transfer);
    }

    @Override
    public Optional<Transfer> deleteTransfer(String operationId) throws ConfirmError {
        for (Transfer transfer : transfers) {
            if (transfer.getOperationId().equals(operationId)) {
                Transfer item = SerializationUtils.clone(transfer);
                transfers.remove(transfer);
                return Optional.of(item);
            }
        }

        throw new ConfirmError("Произошла ошибка при выполнении операции");
    }

    @Override
    public Optional<Transfer> getTransfer(String operationId) {
        for (Transfer transfer : transfers) {
            if (transfer.getOperationId().equals(operationId)) {
                return Optional.of(transfer);
            }
        }

        return Optional.empty();
    }
}