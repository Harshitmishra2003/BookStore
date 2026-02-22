package com.example.Bookstore.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String genre;

    @Column(unique = true)
    private String isbn;

    private BigDecimal price;

    @Column(length = 1000)
    private String description;

    private Integer stock;

    private String imageUrl;
}
