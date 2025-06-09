package com.slavikart.javahw14.repository;

import com.slavikart.javahw14.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByPages(Integer pages);
    
    @Query("SELECT b FROM Book b WHERE b.author = :author ORDER BY b.year DESC")
    List<Book> findLatestByAuthor(@Param("author") String author);
    
    @Query("SELECT b FROM Book b WHERE b.publisher = :publisher AND b.year = 2024")
    List<Book> findByPublisherAndYear(@Param("publisher") String publisher);
    
    List<Book> findByYear(Integer year);
    List<Book> findByGenreAndAuthorAndYear(String genre, String author, Integer year);
    List<Book> findByPagesGreaterThan(Integer pages);
    
    @Query("SELECT b FROM Book b WHERE b.circulation > 10000")
    List<Book> findBestsellers();
    
    @Query("SELECT b FROM Book b WHERE LOWER(b.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Book> findByDescriptionKeyword(@Param("keyword") String keyword);
} 