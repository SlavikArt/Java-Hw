package com.slavikart.javahw14.controller;

import com.slavikart.javahw14.dto.BookDTO;
import com.slavikart.javahw14.entity.Book;
import com.slavikart.javahw14.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAll() {
        return ResponseEntity.ok(bookService.findAll());
    }
    
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.save(book));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/title/{title}")
    public ResponseEntity<List<BookDTO>> findByTitle(@PathVariable String title) {
        return ResponseEntity.ok(bookService.findByTitle(title));
    }
    
    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookDTO>> findByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(bookService.findByAuthor(author));
    }
    
    @GetMapping("/pages/{pages}")
    public ResponseEntity<List<BookDTO>> findByPages(@PathVariable Integer pages) {
        return ResponseEntity.ok(bookService.findByPages(pages));
    }
    
    @GetMapping("/latest/{author}")
    public ResponseEntity<List<BookDTO>> findLatestByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(bookService.findLatestByAuthor(author));
    }
    
    @GetMapping("/publisher/{publisher}")
    public ResponseEntity<List<BookDTO>> findByPublisherAndYear(@PathVariable String publisher) {
        return ResponseEntity.ok(bookService.findByPublisherAndYear(publisher));
    }
    
    @GetMapping("/year/{year}")
    public ResponseEntity<List<BookDTO>> findByYear(@PathVariable Integer year) {
        return ResponseEntity.ok(bookService.findByYear(year));
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<BookDTO>> findByGenreAndAuthorAndYear(
            @RequestParam String genre,
            @RequestParam String author,
            @RequestParam Integer year) {
        return ResponseEntity.ok(bookService.findByGenreAndAuthorAndYear(genre, author, year));
    }
    
    @GetMapping("/bestsellers")
    public ResponseEntity<List<BookDTO>> findBestsellers() {
        return ResponseEntity.ok(bookService.findBestsellers());
    }
    
    @GetMapping("/description")
    public ResponseEntity<List<BookDTO>> findByDescriptionKeyword(@RequestParam String keyword) {
        return ResponseEntity.ok(bookService.findByDescriptionKeyword(keyword));
    }
} 