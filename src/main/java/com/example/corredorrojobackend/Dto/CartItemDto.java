package com.example.corredorrojobackend.Dto;

import com.example.corredorrojobackend.Entity.Cart;
import com.example.corredorrojobackend.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {

    private Long id;
    private Cart cart;
    private Product product;
    private int quantity;
    private BigDecimal price;

}
