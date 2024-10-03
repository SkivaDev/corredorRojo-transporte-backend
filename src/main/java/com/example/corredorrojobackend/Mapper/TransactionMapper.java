package com.example.corredorrojobackend.Mapper;

import com.example.corredorrojobackend.Dto.TransactionDto;
import com.example.corredorrojobackend.Entity.Transaction;

public class TransactionMapper {

    public static TransactionDto mapToTransactionDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getCard(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getCreatedAt()
        );
    }

    public static Transaction mapToTransaction(TransactionDto transactionDto) {
        return new Transaction(
                transactionDto.getId(),
                transactionDto.getCard(),
                transactionDto.getTransactionType(),
                transactionDto.getAmount(),
                transactionDto.getCreatedAt()
        );
    }
}
