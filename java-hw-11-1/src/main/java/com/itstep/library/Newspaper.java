package com.itstep.library;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Newspaper implements LibraryItem {
    private String title;
    private LocalDate publishDate;
    private List<String> headlines;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void displayInfo() {
        System.out.println("Newspaper: " + title + ", Date: " + publishDate);
        System.out.println("Headlines:");
        headlines.forEach(h -> System.out.println("- " + h));
    }
} 