package com.example.corredorrojobackend.Service.impl;

import com.example.corredorrojobackend.Dto.CartDto;
import com.example.corredorrojobackend.Dto.CartItemDto;
import com.example.corredorrojobackend.Entity.Cart;
import com.example.corredorrojobackend.Entity.CartItem;
import com.example.corredorrojobackend.Entity.Product;
import com.example.corredorrojobackend.Exception.ResourceNotFoundException;
import com.example.corredorrojobackend.Mapper.CartItemMapper;
import com.example.corredorrojobackend.Repository.CartItemRepository;
import com.example.corredorrojobackend.Repository.CartRepository;
import com.example.corredorrojobackend.Repository.ProductRepository;
import com.example.corredorrojobackend.Service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private CartItemRepository cartItemRepository;
    private CartRepository cartRepository;
    private ProductRepository productRepository;

    @Override
    public CartItemDto createCartItem(long cartId, long productId) {

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart with the id " + cartId + "dont exist" ));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product with the id " + productId + "dont exist" ));

        CartItem newCartItem = new CartItem();
        newCartItem.setProduct(product);
        newCartItem.setCart(cart);
        newCartItem.setQuantity(1);
        newCartItem.setPrice(product.getPrice());

        CartItem savedCartItem = cartItemRepository.save(newCartItem);
        return CartItemMapper.mapToCartItemDto(savedCartItem);

        /*
        //Agrega un producto al carrito del usuario. Si ya existe, aumenta la cantidad.
        CartItem cartItem = CartItemMapper.mapToCartItem(cartItemDto);

        CartItem cartItemExist = cartItemRepository.findByCartIdAndProductId(cartItem.getCart().getId(), cartItem.getProduct().getId());

        //si esta, agrego quantity +1 y price (pricePro * quantity)
        if(cartItemExist != null) {
            cartItemExist.setQuantity(cartItemExist.getQuantity() + cartItem.getQuantity()); // Le agrego cartItemDto.quantity 5 + 3
            cartItemExist.setPrice(cartItemExist.getPrice().add(cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())))); // (5 * 10) + (3 * 10)
            CartItem savedCartItem = cartItemRepository.save(cartItemExist); // Depues lo guardo
            return CartItemMapper.mapToCartItemDto(savedCartItem);
        }

        // no esta, creo un nuevo cartItem quantity 1 y price (pricePro * 1)
        cartItem.setQuantity(cartItem.getQuantity());// redundante
        cartItem.setPrice(cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())));
        CartItem savedCartItem = cartItemRepository.save(cartItem);

        return CartItemMapper.mapToCartItemDto(savedCartItem);*/
    }

    @Override
    public CartItemDto getCartItemById(Long cartItemId) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem with the id " + cartItemId + "dont exist" ));

        return CartItemMapper.mapToCartItemDto(cartItem);
    }

    @Override
    public List<CartItemDto> getAllCartItemsByCartId(Long cartId) {

        List<CartItem> cartItems = cartItemRepository.findByCartId(cartId);

        return cartItems.stream().map(cartItem -> {
            return new CartItemDto(
                    cartItem.getId(),
                    cartItem.getCart(),   // Directamente puedes obtener la referencia al Cart
                    cartItem.getProduct(), // Directamente puedes obtener la referencia al Product
                    cartItem.getQuantity(),
                    cartItem.getPrice()
            );
        }).collect(Collectors.toList());
    }

    @Override
    public List<CartItemDto> getAllCartItems() {

        List<CartItem> cartItems = cartItemRepository.findAll();
        return cartItems.stream().map((cartItem) -> CartItemMapper.mapToCartItemDto(cartItem))
                .collect(Collectors.toList());
    }

    @Override
    public CartItemDto updateCartItem(Long cartItemId, CartItemDto updatedCartItemDto) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(
                () -> new ResourceNotFoundException("CartItem with the id " + cartItemId + "dont exist" )
        );

        cartItem.setCart(updatedCartItemDto.getCart());
        cartItem.setProduct(updatedCartItemDto.getProduct());
        cartItem.setPrice(updatedCartItemDto.getPrice());
        cartItem.setQuantity(updatedCartItemDto.getQuantity());


        CartItem savedCartItem = cartItemRepository.save(cartItem);

        return CartItemMapper.mapToCartItemDto(savedCartItem);
    }

    @Override
    public void deleteCartItem(Long cartItemId) {

        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(
                () -> new ResourceNotFoundException("CartItem with the id " + cartItemId + "dont exist" )
        );
        cartItemRepository.delete(cartItem);
    }

    @Override
    public CartItemDto updateCartItemQuantity(Long cartItemId, int quantity) {

        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(
                () -> new ResourceNotFoundException("CartItem with the id " + cartItemId + "dont exist" )
        );

        if(quantity >= 0) {
            cartItemRepository.delete(cartItem);
        };

        cartItem.setQuantity(quantity);

        CartItem savedCartItem = cartItemRepository.save(cartItem);

        return CartItemMapper.mapToCartItemDto(savedCartItem);
    }
}
