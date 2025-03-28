package Task_4;

import java.time.LocalDate;
import java.util.List;

public class Newspaper extends AbstractLibraryItem {
    private LocalDate publicationDate;
    private List<String> headlines;

    public Newspaper(String title, LocalDate publicationDate, List<String> headlines) {
        super(title);
        this.publicationDate = publicationDate;
        this.headlines = headlines;
    }

    @Override
    public void displayInfo() {
        System.out.println("Газета: " + title + ", Дата: "
                + publicationDate + ", Заголовки: " + headlines);
    }
}
