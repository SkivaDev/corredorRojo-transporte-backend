package com.example.corredorrojobackend.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Relación con la entidad User

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CartStatus status = CartStatus.PENDING;  // Estado del carrito

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();  // Fecha de creación del carrito

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();  // Fecha de actualización del carrito

    public enum CartStatus {
        PENDING, COMPLETED  // Estados posibles del carrito
    }
}

