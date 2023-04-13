package com.example.mariadbconnect.data.entity;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity  //해당 클래스가 엔티티임을 명시하기 위한 어노테이션이다.
@Table(name="product") //데이터베이스의 테이블명
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Builder
    public Product(Long number, String name, Integer price, Integer stock, LocalDateTime updatedAt,LocalDateTime createdAt) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.updatedAt = updatedAt;
        this.createdAt=createdAt;
    }
}
