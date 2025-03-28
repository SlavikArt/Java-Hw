package Task_4;

public class Task_4 {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();

        catalog.initializeTestData();

        catalog.addRandomItem();

        System.out.println("Повний каталог:");
        catalog.displayCatalog();

        System.out.println("\nПошук за назвою 'Гаррі Поттер':");
        catalog.searchByTitle("Гаррі Поттер").forEach(LibraryItem::displayInfo);

        System.out.println("\nПошук за автором 'Дж. К. Ролінг':");
        catalog.searchByAuthor("Дж. К. Ролінг").forEach(Book::displayInfo);

        System.out.println("\nВидалення 'День':");
        boolean removed = catalog.removeItemByTitle("День");
        System.out.println("Видалено: " + removed);

        System.out.println("\nКаталог після видалення:");
        catalog.displayCatalog();
    }
}
