package com.example.corredorrojobackend.Service;

import com.example.corredorrojobackend.Dto.CartDto;

import java.util.List;

public interface CartService {

    CartDto createCart(CartDto cartDto);

    CartDto getCartById(Long cartId);

    CartDto getCartByUserId(Long userId);

    List<CartDto> getAllCarts();

    CartDto updateCart(Long cartId, CartDto updatedCartDto);

    void deleteCart(Long cartId);

    CartDto getPendingCartByUserId(Long userId);

    void checkout (long cartId);

}
