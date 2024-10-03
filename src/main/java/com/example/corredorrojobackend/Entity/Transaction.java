package com.example.corredorrojobackend.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)  // Cambiado a 'card_id'
    private Card card;  // Relación con la entidad Card

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;  // Tipo de transacción

    @Column(name = "amount", nullable = false)  // Asegúrate de que el nombre de la columna sea 'amount'
    private BigDecimal amount;  // Monto de la transacción

    @Column(name = "created_at", nullable = false, updatable = false)  // Asegúrate de que coincida con 'created_at'
    private LocalDateTime createdAt = LocalDateTime.now();  // Fecha y hora de la transacción

    public enum TransactionType {
        RECHARGE, FARE  // Cambiado para coincidir con el ENUM de la base de datos
    }

}

