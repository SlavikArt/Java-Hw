package com.slavikart.javahw14.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String author;
    
    @Column(name = "publish_year")
    private Integer year;
    
    private String publisher;
    private String genre;
    private Integer pages;
    private String description;
    private Integer circulation;
} 