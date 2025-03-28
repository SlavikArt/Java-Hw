package Task_4;

import java.util.List;

public class Almanac extends AbstractLibraryItem {
    private List<Book> books;

    public Almanac(String title, List<Book> books) {
        super(title);
        this.books = books;
    }

    @Override
    public void displayInfo() {
        System.out.println("Альманах: " + title + ", Книги: ");
        for (Book book : books) {
            System.out.println("  - " + book.getTitle() + " (" + book.getAuthor() + ")");
        }
    }
}
