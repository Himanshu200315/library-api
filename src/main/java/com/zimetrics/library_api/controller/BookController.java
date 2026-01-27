package com.zimetrics.library_api.controller;



import com.zimetrics.library_api.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private Map<Long, Book> bookStore = new HashMap<>();

    @PostMapping
    public String addBook(@RequestBody Book book) {
        bookStore.put(book.getId(), book);
        return "Book added successfully";
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookStore.get(id);
    }

    @GetMapping("/search")
    public List<Book> searchByYear(@RequestParam int year) {
        return bookStore.values()
                .stream()
                .filter(book -> book.getYear() == year)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookStore.remove(id);
        return "Book deleted successfully";
    }
}

