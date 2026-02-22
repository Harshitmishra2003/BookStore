package com.example.Bookstore.Dto;

import lombok.Data;

@Data
public class OrderItemRequest {

    private Long bookId;
    private Integer quantity;
}
