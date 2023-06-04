package com.example.transactionproject.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Transaction {

    //TODO it should be an ENUM
    private String type;
    private Date date;
    private int accountNumber;
    //TODO it should be an ENUM
    private String currency;
    private double amount;
    private String merchantName;
    private String merchantLogo;

}
