package com.example.corredorrojobackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private int pointsNeeded;
    private int stock;
    private LocalDateTime createdAt;

}
