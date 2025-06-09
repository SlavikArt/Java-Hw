package com.itstep.library;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Almanac implements LibraryItem {
    private String title;
    private List<Book> works;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void displayInfo() {
        System.out.println("Almanac: " + title);
        System.out.println("Works included:");
        works.forEach(b -> System.out.println("- " + b.getTitle() + " by " + b.getAuthor()));
    }
} 