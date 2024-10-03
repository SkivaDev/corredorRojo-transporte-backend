package com.example.corredorrojobackend.Mapper;

import com.example.corredorrojobackend.Dto.ProductDto;
import com.example.corredorrojobackend.Entity.Product;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getImageUrl(),
                product.getPrice(),
                product.getPointsNeeded(),
                product.getStock(),
                product.getCreatedAt()
        );
    }

    public static Product mapToProduct(ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getImageUrl(),
                productDto.getPrice(),
                productDto.getPointsNeeded(),
                productDto.getStock(),
                productDto.getCreatedAt()
        );
    }


}
