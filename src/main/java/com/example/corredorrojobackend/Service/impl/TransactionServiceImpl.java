package com.example.corredorrojobackend.Service.impl;

import com.example.corredorrojobackend.Dto.TransactionDto;
import com.example.corredorrojobackend.Entity.Product;
import com.example.corredorrojobackend.Entity.Transaction;
import com.example.corredorrojobackend.Mapper.ProductMapper;
import com.example.corredorrojobackend.Mapper.TransactionMapper;
import com.example.corredorrojobackend.Repository.TransactionRepository;
import com.example.corredorrojobackend.Service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        return null;
    }

    @Override
    public TransactionDto getTransactionById(Long transactionId) {
        return null;
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().map((transaction) -> TransactionMapper.mapToTransactionDto(transaction))
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto updateTransaction(Long transactionId, TransactionDto transactionDto) {
        return null;
    }

    @Override
    public void deleteTransaction(Long transactionId) {

    }
}
