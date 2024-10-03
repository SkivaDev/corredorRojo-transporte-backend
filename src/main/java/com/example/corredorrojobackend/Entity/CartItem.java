package com.example.corredorrojobackend.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;  // Relación con la entidad Cart

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;  // Relación con la entidad Product

    @Column(nullable = false)
    private int quantity;  // Cantidad agregada al carrito

    @Column(nullable = false)
    private BigDecimal price;  // Precio del producto al momento de la compra

}

