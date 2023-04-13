package com.example.mariadbconnect.data.dto;

import com.example.mariadbconnect.data.entity.Product;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductResponseDto {


    private Long number;
    private String name;
    private int price;
    private int stock;
    private LocalDateTime updatedAt;

    public Product toEntity(){

        Product build = Product.builder()
                .number(number)
                .stock(stock)
                .name(name)
                .price(price)
                .updatedAt(updatedAt)
                .build();
        return build;

    }


}