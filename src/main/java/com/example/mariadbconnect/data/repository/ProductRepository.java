package com.example.mariadbconnect.data.repository;

import com.example.mariadbconnect.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
