package com.example.corredorrojobackend.Controller;

import com.example.corredorrojobackend.Dto.CartDto;
import com.example.corredorrojobackend.Dto.CartItemDto;
import com.example.corredorrojobackend.Mapper.CartMapper;
import com.example.corredorrojobackend.Repository.CartRepository;
import com.example.corredorrojobackend.Service.CartItemService;
import com.example.corredorrojobackend.Service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/carts")
@CrossOrigin("*")
public class CartController {

    private CartService cartService;
    private CartItemService cartItemService;

    // Obtener el carrito PENDIENTE del usuario
    @GetMapping
    public ResponseEntity<CartDto> getCartByUserId(@RequestParam Long userId) {
        CartDto cartDto = cartService.getPendingCartByUserId(userId);

        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    //Marca el carrito como "COMPLETED" y procede al checkout.
    @PostMapping("{cartId}/checkout")
    public ResponseEntity<Void> checkoutCart(@PathVariable long cartId) {
        cartService.checkout(cartId);
        return ResponseEntity.ok().build();
    }

    /*
    // Obtener CartItems del usuario
    @GetMapping("{userId}")
    public List<CartItemDto> getCartItemsByUserId(@PathVariable("userId") Long userId) {
        CartDto cartDto = cartService.getCartByUserId(userId);

        return cartItemService.getAllCartItemsByCartId(cartDto.getId());
    }*/


}
