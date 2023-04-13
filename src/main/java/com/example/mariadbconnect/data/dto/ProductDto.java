package com.example.mariadbconnect.data.dto;


import com.example.mariadbconnect.data.entity.Product;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDto {

    private String name;
    private int price;
    private int stock;
    private LocalDateTime createdAt;

    public Product toEntity(){

        Product build = Product.builder()
                .stock(stock)
                .name(name)
                .price(price)
                .createdAt(createdAt)
                .build();
        return build;

    }

}