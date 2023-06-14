package com.example.transactionproject.controller;

import com.example.transactionproject.dto.TransactionResponse;
import com.example.transactionproject.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/{accountNumber}")
    public List<TransactionResponse> findAllByAccountNumber (@PathVariable int accountNumber) {
        return transactionService.findAllByAccountNumber(accountNumber);
    }
}
