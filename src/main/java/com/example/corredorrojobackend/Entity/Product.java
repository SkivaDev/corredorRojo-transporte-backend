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
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;  // Nombre del producto

    @Column(columnDefinition = "TEXT")  // Para texto más largo
    private String description;  // Descripción del producto

    @Column(name = "image_url", nullable = false)
    private String imageUrl = "https://i.pinimg.com/564x/63/55/a0/6355a0fe532c2cf0d195c46d2e67e423.jpg";

    @Column(nullable = false)
    private BigDecimal price;  // Precio del producto

    @Column(name = "points_needed", nullable = false)
    private int pointsNeeded;  // Puntos necesarios para canjear el producto

    @Column(nullable = false)
    private int stock;  // Cantidad de productos en inventario

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();  // Fecha de creación del producto

}

