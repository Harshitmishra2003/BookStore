package com.example.Bookstore.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.Bookstore.Dto.OrderRequest;
import com.example.Bookstore.Entities.Order;
import com.example.Bookstore.Services.OrderService;

import java.util.List;


@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {


private final OrderService service;


@GetMapping
public List<Order> all() { return service.all(); }


@GetMapping("/{id}")
public Order get(@PathVariable Long id) { return service.get(id); }


@PostMapping
public Order place(@RequestBody OrderRequest req) {
return service.placeOrder(req);
}


@PutMapping("/{id}/status")
public Order update(@PathVariable Long id, @RequestParam String status) {
return service.updateStatus(id, status);
}
}
