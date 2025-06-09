package com.slavikart.javahw14.service;

import com.slavikart.javahw14.dto.BookDTO;
import com.slavikart.javahw14.entity.Book;
import com.slavikart.javahw14.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepo;
    
    public List<BookDTO> findAll() {
        return bookRepo.findAll().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
    
    public Book save(Book book) {
        return bookRepo.save(book);
    }
    
    public void delete(Long id) {
        bookRepo.deleteById(id);
    }
    
    public List<BookDTO> findByTitle(String title) {
        return bookRepo.findByTitle(title).stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
    
    public List<BookDTO> findByAuthor(String author) {
        return bookRepo.findByAuthor(author).stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
    
    public List<BookDTO> findByPages(Integer pages) {
        return bookRepo.findByPages(pages).stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
    
    public List<BookDTO> findLatestByAuthor(String author) {
        return bookRepo.findLatestByAuthor(author).stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
    
    public List<BookDTO> findByPublisherAndYear(String publisher) {
        return bookRepo.findByPublisherAndYear(publisher).stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
    
    public List<BookDTO> findByYear(Integer year) {
        return bookRepo.findByYear(year).stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
    
    public List<BookDTO> findByGenreAndAuthorAndYear(String genre, String author, Integer year) {
        return bookRepo.findByGenreAndAuthorAndYear(genre, author, year).stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
    
    public List<BookDTO> findBestsellers() {
        return bookRepo.findBestsellers().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
    
    public List<BookDTO> findByDescriptionKeyword(String keyword) {
        return bookRepo.findByDescriptionKeyword(keyword).stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
    
    private BookDTO toDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setGenre(book.getGenre());
        dto.setYear(book.getYear());
        dto.setPublisher(book.getPublisher());
        dto.setPages(book.getPages());
        return dto;
    }
} 