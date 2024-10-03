package com.example.corredorrojobackend.Dto;

import com.example.corredorrojobackend.Entity.Card;
import com.example.corredorrojobackend.Entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Long id;
    private Card card;
    private Transaction.TransactionType transactionType;
    private BigDecimal amount;
    private LocalDateTime createdAt;

}
