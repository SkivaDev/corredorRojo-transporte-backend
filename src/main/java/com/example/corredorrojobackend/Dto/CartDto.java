package com.example.corredorrojobackend.Dto;

import com.example.corredorrojobackend.Entity.Cart;
import com.example.corredorrojobackend.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private Long id;
    private User user;
    private Cart.CartStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
