package Task_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LibraryCatalog {
    private List<AbstractLibraryItem> items = new ArrayList<>();

    public void initializeTestData() {
        addItem(new Book("Гаррі Поттер", "Дж. К. Ролінг", "Фентезі", 400));
        addItem(new Newspaper("День", java.time.LocalDate.of(2023, 11, 1),
                List.of("Політика", "Економіка")));
        addItem(new Almanac("Класика", List.of(
                new Book("Майстер і Маргарита", "Михайло Булгаков", "Роман", 384),
                new Book("Злочин і кара", "Федір Достоєвський", "Роман", 671)
        )));
    }

    public void addItem(AbstractLibraryItem item) {
        items.add(item);
    }

    public void addRandomItem() {
        Random random = new Random();
        int type = random.nextInt(3);
        switch (type) {
            case 0:
                items.add(new Book("Випадкова книга", "Невідомий автор", "Жанр",
                        random.nextInt(500) + 100));
                break;
            case 1:
                items.add(new Newspaper("Випадкова газета", java.time.LocalDate.now(),
                        List.of("Новина")));
                break;
            case 2:
                items.add(new Almanac("Випадковий альманах", List.of(
                        new Book("Твір", "Автор", "Жанр", 100)
                )));
                break;
        }
    }

    public boolean removeItemByTitle(String title) {
        return items.removeIf(item -> item.getTitle().equalsIgnoreCase(title));
    }

    public void displayCatalog() {
        if (items.isEmpty())
            System.out.println("Каталог порожній.");
        else
            items.forEach(LibraryItem::displayInfo);
    }

    public List<AbstractLibraryItem> searchByTitle(String title) {
        List<AbstractLibraryItem> result = new ArrayList<>();
        for (AbstractLibraryItem item : items)
            if (item.getTitle().equalsIgnoreCase(title))
                result.add(item);
        return result;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (LibraryItem item : items)
            if (item instanceof Book && ((Book) item).getAuthor().equalsIgnoreCase(author))
                result.add((Book) item);
        return result;
    }
}
