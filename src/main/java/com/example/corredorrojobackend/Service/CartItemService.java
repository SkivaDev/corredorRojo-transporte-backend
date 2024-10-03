package com.example.corredorrojobackend.Service;

import com.example.corredorrojobackend.Dto.CartItemDto;
import com.example.corredorrojobackend.Dto.ProductDto;

import java.util.List;

public interface CartItemService {

    CartItemDto createCartItem(long cartId, long productId);

    CartItemDto getCartItemById(Long cartItemId);

    List<CartItemDto> getAllCartItemsByCartId(Long cartId);

    List<CartItemDto> getAllCartItems();

    CartItemDto updateCartItem(Long cartItemId, CartItemDto updatedCartItemDto);

    void deleteCartItem(Long cartItemId);

    CartItemDto updateCartItemQuantity(Long cartItemId, int quantity);

}
