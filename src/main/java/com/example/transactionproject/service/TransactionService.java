package com.example.transactionproject.service;

import com.example.transactionproject.dto.TransactionResponse;
import com.example.transactionproject.mapper.TransactionMapper;
import com.example.transactionproject.entity.Transaction;
import com.example.transactionproject.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<TransactionResponse> findAllByAccountNumber(int accountNumber){
        List<Transaction> transactionList = transactionRepository.findAllByAccountNumber(accountNumber);

        return transactionList.stream()
                .map(this::toTransactionResponse)
                .collect(toList());


    }

    private TransactionResponse toTransactionResponse (Transaction transaction) {
        return TransactionResponse.builder()
                .id(transaction.getId())
                .type(transaction.getType())
                .accountNumber(transaction.getAccountNumber())
                .currency(transaction.getCurrency())
                .amount(transaction.getAmount())
                .merchantName(transaction.getMerchantName())
                .merchantLogo(transaction.getMerchantLogo())
                .build();
    }
}
