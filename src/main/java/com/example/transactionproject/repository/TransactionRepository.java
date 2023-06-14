package com.example.transactionproject.repository;

import com.example.transactionproject.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findAllByAccountNumber(int accountNumber);
}
