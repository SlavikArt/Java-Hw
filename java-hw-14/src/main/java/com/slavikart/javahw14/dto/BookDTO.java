package com.slavikart.javahw14.dto;

import lombok.Data;

@Data
public class BookDTO {
    private String title;
    private String author;
    private String genre;
    private Integer year;
    private String publisher;
    private Integer pages;
} 