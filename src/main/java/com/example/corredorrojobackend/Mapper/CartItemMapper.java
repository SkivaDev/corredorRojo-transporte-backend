package com.example.corredorrojobackend.Mapper;

import com.example.corredorrojobackend.Dto.CartItemDto;
import com.example.corredorrojobackend.Entity.CartItem;

public class CartItemMapper {

    public static CartItemDto mapToCartItemDto(CartItem cartItem) {
        return new CartItemDto(
                cartItem.getId(),
                cartItem.getCart(),
                cartItem.getProduct(),
                cartItem.getQuantity(),
                cartItem.getPrice()
        );
    }

    public static CartItem mapToCartItem(CartItemDto cartItemDto) {
        return new CartItem(
                cartItemDto.getId(),
                cartItemDto.getCart(),
                cartItemDto.getProduct(),
                cartItemDto.getQuantity(),
                cartItemDto.getPrice()
        );
    }
}
