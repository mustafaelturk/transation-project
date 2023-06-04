package com.example.transactionproject.controller;

import com.example.transactionproject.dto.TransactionResponse;
import com.example.transactionproject.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public List<TransactionResponse> findAllByAccountNumber (int accountNumber) {
        return transactionService.findAllByAccountNumber(accountNumber);
    }
}
