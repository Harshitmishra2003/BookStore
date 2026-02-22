package com.example.Bookstore.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Bookstore.Entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {}
