package com.example.transactionproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public class Transaction {

    //TODO it should be an ENUM
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String type;
    private Date date;
    private int accountNumber;
    //TODO it should be an ENUM
    private String currency;
    private double amount;
    private String merchantName;
    private String merchantLogo;

}
