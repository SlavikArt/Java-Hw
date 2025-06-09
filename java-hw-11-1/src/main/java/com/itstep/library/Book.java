package com.itstep.library;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements LibraryItem {
    private String author;
    private String title;
    private String genre;
    private int pages;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book: " + title + " by " + author + ", Genre: " + genre + ", Pages: " + pages);
    }
} 