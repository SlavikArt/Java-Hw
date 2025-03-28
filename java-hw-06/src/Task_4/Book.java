package Task_4;

public class Book extends AbstractLibraryItem {
    private String author;
    private String genre;
    private int pages;

    public Book(String title, String author, String genre, int pages) {
        super(title);
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Книга: " + title + ", Автор: " + author
                + ", Жанр: " + genre + ", Сторінок: " + pages);
    }
}
