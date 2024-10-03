package com.example.corredorrojobackend.Repository;

import com.example.corredorrojobackend.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
