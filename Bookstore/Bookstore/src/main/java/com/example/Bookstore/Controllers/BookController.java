package com.example.Bookstore.Controllers;

import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookstore.Dto.BookDto;
import com.example.Bookstore.Entities.Book;
import com.example.Bookstore.Services.BookService;



@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return service.get(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Book addBook(@RequestBody BookDto dto) {
        return service.create(dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody BookDto dto) {
        return service.update(id, dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.delete(id);
    }
}
