package com.example.corredorrojobackend.Mapper;

import com.example.corredorrojobackend.Dto.CartDto;
import com.example.corredorrojobackend.Entity.Cart;

public class CartMapper {

    public static CartDto mapToCartDto(Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getUser(),
                cart.getStatus(),
                cart.getUpdatedAt(),
                cart.getCreatedAt()
        );
    }

    public static Cart mapToCart(CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getUser(),
                cartDto.getStatus(),
                cartDto.getUpdatedAt(),
                cartDto.getCreatedAt()
        );
    }
}
