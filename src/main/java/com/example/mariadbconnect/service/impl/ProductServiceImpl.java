package com.example.mariadbconnect.service.impl;


import com.example.mariadbconnect.data.dao.ProductDAO;
import com.example.mariadbconnect.data.dto.ProductDto;
import com.example.mariadbconnect.data.dto.ProductResponseDto;
import com.example.mariadbconnect.data.entity.Product;
import com.example.mariadbconnect.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO){
        this.productDAO=productDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        Optional<Product> product = productDAO.selectProduct(number);
        Product product1 = product.get();
        ProductResponseDto productResponseDto =new ProductResponseDto(
                product1.getNumber(),
                product1.getName(),
                product1.getPrice(),
                product1.getStock(),
                product1.getUpdatedAt()
        );


        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        productDto.setCreatedAt(LocalDateTime.now());
        Product entity = productDto.toEntity();
        Product product = productDAO.insertProduct(entity);

        ProductResponseDto productResponseDto = new ProductResponseDto(
                product.getNumber(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getUpdatedAt()
        );

        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product changedProduct = productDAO.updateProductName(number, name);

        ProductResponseDto productResponseDto = new ProductResponseDto(
                changedProduct.getNumber(),
                changedProduct.getName(),
                changedProduct.getPrice(),
                changedProduct.getStock(),
                changedProduct.getUpdatedAt()
        );

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}
