package com.example.Bookstore.Entities;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Data
@Entity
@Table(name = "orders")
public class Order {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne
private User user;


@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
@JsonManagedReference
private List<OrderItem> items;


private String status; 
private String paymentStatus;
}