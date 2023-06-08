package com.example.transactionproject.service;

import com.example.transactionproject.dto.TransactionResponse;
import com.example.transactionproject.mapper.TransactionMapper;
import com.example.transactionproject.entity.Transaction;
import com.example.transactionproject.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionMapper transactionMapper;
    private final TransactionRepository transactionRepository;

    List<Transaction> transactions = List.of(
            Transaction.builder()
                    .type("CASH")
                    .date(new Date())
                    .accountNumber(54321)
                    .currency("dollar")
                    .amount(25)
                    .merchantName("1 dollar Shop")
                    .merchantLogo("Logo")
                    .build(),

            Transaction.builder()
                    .type("CARD")
                    .date(new Date())
                    .accountNumber(54321)
                    .currency("EUR")
                    .amount(3)
                    .merchantName("coffee shop")
                    .merchantLogo("Logo")
                    .build(),

            Transaction.builder()
                    .type("CASH")
                    .date(new Date())
                    .accountNumber(54321)
                    .currency("POUND")
                    .amount(10)
                    .merchantName("sushi")
                    .merchantLogo("Logo")
                    .build()

    );


    public List<TransactionResponse> findAllByAccountNumber(int accountNumber){

//        List<Transaction> transactionList = transactions.stream()
//                .filter(transaction -> transaction.getAccountNumber() == accountNumber)
//                .collect(Collectors.toList());

        List<Transaction> transactionList = transactionRepository.findAllByAccountNumber(accountNumber);

        List<TransactionResponse> transactionResponseList = transactionMapper
                .toTransactionResponseList(transactionList);

        return transactionResponseList;


    }
}
