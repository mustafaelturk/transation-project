package com.example.transactionproject.mapper;

import com.example.transactionproject.dto.TransactionResponse;
import com.example.transactionproject.entity.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionMapper {

    public List<TransactionResponse> toTransactionResponseList (List<Transaction> transactions) {

        List<TransactionResponse> transactionResponses = new ArrayList<>();

        for (Transaction transaction : transactions) {
            TransactionResponse transactionResponse = new TransactionResponse();
            transactionResponse.setType(transaction.getType());
            transactionResponse.setDate(transaction.getDate());
            transactionResponse.setAccountNumber(transaction.getAccountNumber());
            transactionResponse.setCurrency(transaction.getCurrency());
            transactionResponse.setAmount(transactionResponse.getAmount());
            transactionResponse.setMerchantName(transaction.getMerchantName());
            transactionResponse.setMerchantLogo(transaction.getMerchantLogo());

            transactionResponses.add(transactionResponse);
        }

        return transactionResponses;
    }

}
