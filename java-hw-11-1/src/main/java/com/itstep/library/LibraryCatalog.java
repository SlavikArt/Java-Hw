package com.itstep.library;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Data
public class LibraryCatalog {
    private List<LibraryItem> items = new ArrayList<>();
    private Random random = new Random();

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addRandomItem() {
        int type = random.nextInt(3);
        switch (type) {
            case 0 -> items.add(new Book("Author " + random.nextInt(100), "Book " + random.nextInt(100), 
                "Genre " + random.nextInt(10), random.nextInt(500)));
            case 1 -> {
                List<String> headlines = new ArrayList<>();
                for (int i = 0; i < 3; i++)
                    headlines.add("Headline " + random.nextInt(100));
                items.add(new Newspaper("Newspaper " + random.nextInt(100), 
                    java.time.LocalDate.now().minusDays(random.nextInt(30)), headlines));
            }
            case 2 -> {
                List<Book> works = new ArrayList<>();
                for (int i = 0; i < 3; i++)
                    works.add(new Book("Author " + random.nextInt(100), "Book " + random.nextInt(100), 
                        "Genre " + random.nextInt(10), random.nextInt(500)));
                items.add(new Almanac("Almanac " + random.nextInt(100), works));
            }
        }
    }

    public void removeByTitle(String title) {
        items.removeIf(item -> item.getTitle().equals(title));
    }

    public void displayAll() {
        items.forEach(LibraryItem::displayInfo);
    }

    public List<LibraryItem> searchByTitle(String title) {
        return items.stream()
            .filter(item -> item.getTitle().toLowerCase().contains(title.toLowerCase()))
            .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author) {
        return items.stream()
            .filter(item -> item instanceof Book)
            .map(item -> (Book) item)
            .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
            .collect(Collectors.toList());
    }

    public void initTestData() {
        items.add(new Book("John Smith", "The Great Adventure", "Fiction", 300));
        items.add(new Book("Jane Doe", "Mystery House", "Mystery", 250));
        
        List<String> headlines = new ArrayList<>();
        headlines.add("Breaking News");
        headlines.add("Local Events");
        headlines.add("Sports Update");
        items.add(new Newspaper("Daily News", java.time.LocalDate.now(), headlines));
        
        List<Book> works = new ArrayList<>();
        works.add(new Book("Author 1", "Story 1", "Fiction", 100));
        works.add(new Book("Author 2", "Story 2", "Drama", 150));
        items.add(new Almanac("Best Stories 2024", works));
    }
} 