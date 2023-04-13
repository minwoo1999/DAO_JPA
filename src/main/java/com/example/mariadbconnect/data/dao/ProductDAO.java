package com.example.mariadbconnect.data.dao;

import com.example.mariadbconnect.data.entity.Product;

import java.util.Optional;

public interface ProductDAO {


    // 간단한 crud 작성
    Product insertProduct(Product product);

    Optional<Product> selectProduct(Long number);

    Product updateProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
