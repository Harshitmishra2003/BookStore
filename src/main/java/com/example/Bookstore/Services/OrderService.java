package com.example.Bookstore.Services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.Bookstore.Dto.OrderItemRequest;
import com.example.Bookstore.Dto.OrderRequest;
import com.example.Bookstore.Entities.Book;
import com.example.Bookstore.Entities.Order;
import com.example.Bookstore.Entities.OrderItem;
import com.example.Bookstore.Entities.User;
import com.example.Bookstore.Repositories.BookRepository;
import com.example.Bookstore.Repositories.OrderRepository;
import com.example.Bookstore.Repositories.UserRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderService {


private final UserRepository userRepo;
private final BookRepository bookRepo;
private final OrderRepository orderRepo;


public Order placeOrder(OrderRequest req) {


User user = userRepo.findById(req.getUserId())
.orElseThrow(() -> new RuntimeException("User not found"));


Order order = new Order();
order.setUser(user);
order.setStatus("Pending");
order.setPaymentStatus("Unpaid");


List<OrderItem> items = new ArrayList<>();


for (OrderItemRequest item  : req.getItems()) {
Book book = bookRepo.findById(item.getBookId())
.orElseThrow(() -> new RuntimeException("Book not found"));


OrderItem orderItem = new OrderItem();
orderItem.setOrder(order);
orderItem.setBook(book);
orderItem.setQuantity(item.getQuantity());
orderItem.setTotalPrice(book.getPrice().multiply(
		BigDecimal.valueOf(item.getQuantity())));
items.add(orderItem);
}


order.setItems(items);
return orderRepo.save(order);
}


public List<Order> all() { return orderRepo.findAll(); }


public Order get(Long id) {
return orderRepo.findById(id)
.orElseThrow(() -> new RuntimeException("Order not found"));
}


public Order updateStatus(Long id, String status) {
Order o = get(id);
o.setStatus(status);
return orderRepo.save(o);
}
}