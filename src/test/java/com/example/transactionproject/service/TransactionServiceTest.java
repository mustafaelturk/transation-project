package com.example.transactionproject.service;

import com.example.transactionproject.dto.TransactionResponse;
import com.example.transactionproject.entity.Transaction;
import com.example.transactionproject.repository.TransactionRepository;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class TransactionServiceTest {
    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp () {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllByAccountNumber () {

        when(transactionRepository.findAllByAccountNumber(anyInt()))
                .thenReturn(transactions());

        TransactionService transactionService = new TransactionService(transactionRepository);

        assertEquals(3, transactionService.findAllByAccountNumber(54321).size());
    }

    private List<Transaction> transactions () {
        return List.of(
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
    }

}
