package com.example.corredorrojobackend.Service.impl;

import com.example.corredorrojobackend.Dto.CartDto;
import com.example.corredorrojobackend.Entity.Cart;
import com.example.corredorrojobackend.Exception.ResourceNotFoundException;
import com.example.corredorrojobackend.Mapper.CartMapper;
import com.example.corredorrojobackend.Repository.CartRepository;
import com.example.corredorrojobackend.Service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    @Override
    public CartDto createCart(CartDto cartDto) {

        Cart cart = CartMapper.mapToCart(cartDto);
        Cart savedCart = cartRepository.save(cart);

        return CartMapper.mapToCartDto(savedCart);

    }

    @Override
    public CartDto getCartById(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart with the id " + cartId + "dont exist" ));

        return CartMapper.mapToCartDto(cart);
    }

    @Override
    public CartDto getCartByUserId(Long userId) {
        Cart cart = cartRepository.findByUserIdAndStatus(userId, Cart.CartStatus.PENDING);

        if (cart == null) {
            throw new ResourceNotFoundException("No se encontró el carrito para el usuario con ID: " + userId);
        }

        return CartMapper.mapToCartDto(cart);
    }

    @Override
    public List<CartDto> getAllCarts() {
        List<Cart> carts = cartRepository.findAll();
        return carts.stream().map((cart) -> CartMapper.mapToCartDto(cart))
                .collect(Collectors.toList());
    }

    @Override
    public CartDto updateCart(Long cartId, CartDto updatedCartDto) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(
                () -> new ResourceNotFoundException("Cart with the id " + cartId + "dont exist" )
        );

        cart.setUser(updatedCartDto.getUser());
        cart.setStatus(updatedCartDto.getStatus());
        cart.setUpdatedAt(updatedCartDto.getUpdatedAt());

        Cart savedCart = cartRepository.save(cart);

        return CartMapper.mapToCartDto(savedCart);
    }

    @Override
    public void deleteCart(Long cartId) {

        Cart cart = cartRepository.findById(cartId).orElseThrow(
                () -> new ResourceNotFoundException("Cart with the id " + cartId + "dont exist" )
        );
        cartRepository.delete(cart);

    }

    @Override
    public CartDto getPendingCartByUserId(Long userId) {

        Cart cart = cartRepository.findByUserIdAndStatus(userId, Cart.CartStatus.PENDING);
        if (cart == null) {
            throw new ResourceNotFoundException("No se encontró el carrito PENDIENTE para el usuario con ID: " + userId);
        }

        return CartMapper.mapToCartDto(cart);
    }

    @Override
    public void checkout(long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found with id: " + cartId));

        if (cart.getStatus() == cart.getStatus().COMPLETED) {
            throw new IllegalStateException("Cart has already been checked out");
        }

        // Aquí incluir lógica adicional para procesar el pago, etc.

        // Marca el carrito como COMPLETED
        cart.setStatus(cart.getStatus().COMPLETED);

        cartRepository.save(cart);
    }
}
