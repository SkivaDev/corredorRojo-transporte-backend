package com.example.corredorrojobackend.Controller;

import com.example.corredorrojobackend.Dto.CartItemDto;
import com.example.corredorrojobackend.Service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cart-items")
@CrossOrigin("*")
public class CartItemController {

    private CartItemService cartItemService;

    // Build Add CartItem REST API
    /*@PostMapping
    public ResponseEntity<CartItemDto> createCartItem(@RequestParam long userId, @RequestParam long productId) {
        //EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        CartItemDto savedCartItem = cartItemService.createCartItem();

        return new ResponseEntity<>(savedCartItem, HttpStatus.CREATED);
        
    }*/
    //Obtener todos los cartItems de un Cart
    @GetMapping
    public ResponseEntity<List<CartItemDto>> getCartItemsByCartId(@RequestParam long cartId) {
        List<CartItemDto> cartItems = cartItemService.getAllCartItemsByCartId(cartId);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }


    //Agrega un producto al carrito del usuario. Que no existe
    @PostMapping
    public ResponseEntity<CartItemDto> addCartItem(@RequestParam long cartId, @RequestParam long productId) {
        CartItemDto cartItem = cartItemService.createCartItem(cartId, productId);
        return new ResponseEntity<>(cartItem, HttpStatus.CREATED);
    }

    /*
    //Actualiza la cantidad de un ítem en el carrito. Se puede usar al momento de quitar items del carro
    @PutMapping("{cartItemId}")
    public ResponseEntity<CartItemDto> updateCartItemQuantity(@PathVariable long cartItemId, @RequestParam int newQuantity) {
        CartItemDto updatedCartItem = cartItemService.updateCartItemQuantity(cartItemId, newQuantity);
        return ResponseEntity.ok(updatedCartItem);
    }*/

    //Actualiza la cantidad de cartItems desde el frontend
    @PutMapping("{cartItemId}")
    public ResponseEntity<CartItemDto> updateCartItem(@PathVariable long cartItemId, @RequestBody CartItemDto cartItemDto) {
        CartItemDto updatedCartItem = cartItemService.updateCartItem(cartItemId, cartItemDto);
        return ResponseEntity.ok(updatedCartItem);
    }

    //Eliminar un ítem del carrito
    @DeleteMapping("{cartItemId}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable long cartItemId) {
        cartItemService.deleteCartItem(cartItemId);
        return ResponseEntity.noContent().build();
    }

}
