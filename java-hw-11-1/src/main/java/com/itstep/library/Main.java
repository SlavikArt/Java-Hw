package com.itstep.library;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        
        System.out.println("Initializing test data...");
        catalog.initTestData();
        
        System.out.println("\nDisplaying all items:");
        catalog.displayAll();
        
        System.out.println("\nAdding random items...");
        for (int i = 0; i < 3; i++)
            catalog.addRandomItem();
        
        System.out.println("\nDisplaying all items after adding random ones:");
        catalog.displayAll();
        
        System.out.println("\nSearching for items with 'Story' in title:");
        catalog.searchByTitle("Story").forEach(LibraryItem::displayInfo);
        
        System.out.println("\nSearching for books by author 'John':");
        catalog.searchByAuthor("John").forEach(Book::displayInfo);
        
        System.out.println("\nRemoving item with title 'The Great Adventure'");
        catalog.removeByTitle("The Great Adventure");
        
        System.out.println("\nDisplaying all items after removal:");
        catalog.displayAll();
    }
} 