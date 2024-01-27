package ru.netology.moneytransferservice.service;

import org.springframework.stereotype.Service;
import ru.netology.moneytransferservice.constants.StatusOfTransfer;
import ru.netology.moneytransferservice.exception.ErrorInputData;
import ru.netology.moneytransferservice.model.DataOfTransfer;
import ru.netology.moneytransferservice.model.Transfer;
import ru.netology.moneytransferservice.repository.AccountRepository;
import ru.netology.moneytransferservice.repository.MoneyTransferRepository;
import ru.netology.moneytransferservice.util.GenerateCode;
import ru.netology.moneytransferservice.util.GenerateId;

@Service
public class TransferService {

    private final AccountRepository accountRepository;
    private final TransferBuilder transferBuilder;
    private final GenerateCode generateCode;
    private final GenerateId generateId;
    private final MoneyTransferRepository moneyTransferRepository;

    public TransferService(
            AccountRepository accountRepository,
            TransferBuilder transferBuilder,
            GenerateId generateId,
            GenerateCode generateCode,
            MoneyTransferRepository moneyTransferRepository) {
        this.accountRepository = accountRepository;
        this.transferBuilder = transferBuilder;
        this.generateCode = generateCode;
        this.generateId = generateId;
        this.moneyTransferRepository = moneyTransferRepository;
    }

    public Transfer createTransfer(DataOfTransfer dataOfTransfer) throws ErrorInputData {
        final var accountTo = accountRepository.getAccountForNumber(dataOfTransfer.getCardToNumber());
        final var accountFrom = accountRepository.getAccountForNumber(dataOfTransfer.getCardFromNumber());

        if (accountTo.isPresent() && accountFrom.isPresent()) {
            Transfer transfer = transferBuilder.addCardNumberFrom(accountFrom.get().getNumber())
                    .addCardNumberTo(accountTo.get().getNumber())
                    .addCode(generateCode.getCode())
                    .addOperationId(generateId.getId())
                    .addAmount(dataOfTransfer.getAmount())
                    .addStatus(StatusOfTransfer.NEW)
                    .build();

            moneyTransferRepository.addNewTransfer(transfer);
            return transfer;
        }
        throw new ErrorInputData("Введены некорректные данные");
    }
}
