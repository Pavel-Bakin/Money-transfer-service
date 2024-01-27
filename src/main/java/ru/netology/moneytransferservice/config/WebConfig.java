package ru.netology.moneytransferservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.moneytransferservice.service.TransferBuilder;
import ru.netology.moneytransferservice.util.GenerateCode;
import ru.netology.moneytransferservice.util.GenerateId;
import ru.netology.moneytransferservice.util.MoneyTransfer;

@Configuration
public class WebConfig {

    @Bean
    public TransferBuilder transferBuilder() {
        return new TransferBuilder();
    }

    @Bean
    public GenerateId generateId() {
        return new GenerateId();
    }

    @Bean
    public GenerateCode generateCode() {
        return new GenerateCode();
    }

    @Bean
    public MoneyTransfer moneyTransfer() {
        return new MoneyTransfer();
    }
}
