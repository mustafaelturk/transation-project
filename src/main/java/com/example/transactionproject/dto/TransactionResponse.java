package com.example.transactionproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class TransactionResponse {

    private Long id;
    private String type;
    private Date date;
    private int accountNumber;
    private String currency;
    private double amount;
    private String merchantName;
    private String merchantLogo;

}
