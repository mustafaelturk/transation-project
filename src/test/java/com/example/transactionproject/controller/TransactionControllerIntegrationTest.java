package com.example.transactionproject.controller;

import com.example.transactionproject.dto.TransactionResponse;
import com.example.transactionproject.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
class TransactionControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    public void shouldFindAllByAccountNumber () throws Exception {
        when(transactionService.findAllByAccountNumber(54321))
                .thenReturn(getTransactions());
        mockMvc.perform(get("/api/v1/transactions/54321"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private List<TransactionResponse> getTransactions() {
        return List.of(
                TransactionResponse.builder()
                        .type("CASH")
                        .date(new Date())
                        .accountNumber(54321)
                        .currency("dollar")
                        .amount(25)
                        .merchantName("1 dollar Shop")
                        .merchantLogo("Logo")
                        .build(),

                TransactionResponse.builder()
                        .type("CARD")
                        .date(new Date())
                        .accountNumber(54321)
                        .currency("EUR")
                        .amount(3)
                        .merchantName("coffee shop")
                        .merchantLogo("Logo")
                        .build(),

                TransactionResponse.builder()
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
