package com.zimetrics.library_api.controller;

import com.zimetrics.library_api.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
@CrossOrigin   // allows frontend JS to call backend safely
public class BookController {

    private Map<Long, Book> bookStore = new HashMap<>();

    // ADD BOOK
    @PostMapping
    public String addBook(@RequestBody Book book) {
        bookStore.put(book.getId(), book);
        return "Book added successfully";
    }

    // GET BOOK BY ID
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookStore.get(id);
    }

    // SEARCH BOOK BY YEAR
    @GetMapping("/search")
    public List<Book> searchByYear(@RequestParam int year) {
        return bookStore.values()
                .stream()
                .filter(book -> book.getYear() == year)
                .collect(Collectors.toList());
    }

    // DELETE BOOK
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookStore.remove(id);
        return "Book deleted successfully";
    }
 // GET ALL BOOKS
    @GetMapping
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookStore.values());
    }

}
