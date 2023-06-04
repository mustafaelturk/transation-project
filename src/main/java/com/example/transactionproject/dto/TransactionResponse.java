package com.example.transactionproject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionResponse {

    private String type;
    private Date date;
    private int accountNumber;
    private String currency;
    private double amount;
    private String merchantName;
    private String merchantLogo;

}
