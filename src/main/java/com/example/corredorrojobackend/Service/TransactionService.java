package com.example.corredorrojobackend.Service;

import com.example.corredorrojobackend.Dto.TransactionDto;

import java.util.List;

public interface TransactionService {

    TransactionDto createTransaction(TransactionDto transactionDto);

    TransactionDto getTransactionById(Long transactionId);

    List<TransactionDto> getAllTransactions();

    TransactionDto updateTransaction(Long transactionId, TransactionDto transactionDto);

    void deleteTransaction(Long transactionId);
}
