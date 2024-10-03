package com.example.corredorrojobackend.Controller;

import com.example.corredorrojobackend.Dto.ProductDto;
import com.example.corredorrojobackend.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {

    private ProductService productService;

    //Build Get All Products REST API
    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //Obtener un solo producto
    @GetMapping("{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable long productId) {
        ProductDto product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }
}
