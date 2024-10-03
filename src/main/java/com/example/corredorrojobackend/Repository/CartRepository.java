package com.example.corredorrojobackend.Repository;

import com.example.corredorrojobackend.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserIdAndStatus(Long userId, Cart.CartStatus status); // Método para buscar por usuario y estado
}
