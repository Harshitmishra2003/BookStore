package com.example.Bookstore.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.Bookstore.Dto.BookDto;
import com.example.Bookstore.Entities.Book;
import com.example.Bookstore.Exception.ResourceNotFoundException;
import com.example.Bookstore.Repositories.BookRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {


private final BookRepository repo;



public List<Book> getAll() { return repo.findAll(); }


public Book get(Long id) {
return repo.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Book not found"));
}


public Book create(BookDto dto) {
Book b = new Book();
b.setTitle(dto.getTitle());
b.setAuthor(dto.getAuthor());
b.setGenre(dto.getGenre());
b.setIsbn(dto.getIsbn());
b.setPrice(dto.getPrice());
b.setDescription(dto.getDescription());
b.setStock(dto.getStock());
b.setImageUrl(dto.getImageUrl());
return repo.save(b);
}


public Book update(Long id, BookDto dto) {
Book b = get(id);
b.setPrice(dto.getPrice());
b.setStock(dto.getStock());
b.setDescription(dto.getDescription());
return repo.save(b);
}


public void delete(Long id) { repo.deleteById(id); }
}