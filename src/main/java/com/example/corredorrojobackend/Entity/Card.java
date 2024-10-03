package com.example.corredorrojobackend.Entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "cards")

public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 8)
    private String cardNumber;  // Número único de la tarjeta (16 dígitos)

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Relación con la entidad User (muchas tarjetas a un usuario)

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;  // Saldo de la tarjeta, inicializado en 0.00

    @Column(nullable = false)
    private int points = 0;  // Puntos acumulados, inicializado en 0

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();  // Fecha de creación de la tarjeta

}
