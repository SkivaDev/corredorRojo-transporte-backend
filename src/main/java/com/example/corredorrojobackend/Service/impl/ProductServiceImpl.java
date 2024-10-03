package com.example.corredorrojobackend.Service.impl;

import com.example.corredorrojobackend.Dto.ProductDto;
import com.example.corredorrojobackend.Entity.Product;
import com.example.corredorrojobackend.Mapper.ProductMapper;
import com.example.corredorrojobackend.Repository.ProductRepository;
import com.example.corredorrojobackend.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto getProductById(Long productId) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {

        List<Product> products = productRepository.findAll();
        return products.stream().map((product) -> ProductMapper.mapToProductDto(product))
                .collect(Collectors.toList());

    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto productDto) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }
}
