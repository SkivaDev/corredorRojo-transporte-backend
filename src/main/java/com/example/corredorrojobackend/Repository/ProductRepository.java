package com.example.corredorrojobackend.Repository;

import com.example.corredorrojobackend.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
