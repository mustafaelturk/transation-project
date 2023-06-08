package com.example.transactionproject.service;

import com.example.transactionproject.dto.TransactionResponse;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    void findAllByAccountNumber () {

        List<TransactionResponse> allByAccountNumber = transactionService.findAllByAccountNumber(54321);
        assertEquals(allByAccountNumber.size(),3);
        assertTrue(allByAccountNumber.size() > 0);
    }
}
