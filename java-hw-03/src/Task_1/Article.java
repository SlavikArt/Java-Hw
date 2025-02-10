package Task_1;

public class Article {
    private Human author;
    private String title;
    private double rating;

    public Article(Human author, String title, double rating) {
        this.author = author;
        this.title = title;
        this.rating = rating;
    }

    public Human getAuthor() { return author; }
    public String getTitle() { return title; }
    public double getRating() { return rating; }
}
