package Task_1;

public class Magazine {
    private String name;
    private Frequency frequency;
    private String releaseDate;
    private int circulation;
    private Article[] articles;

    public Magazine(String name, Frequency frequency, String releaseDate,
                    int circulation, Article[] articles) {
        this.name = name;
        this.frequency = frequency;
        this.releaseDate = releaseDate;
        this.circulation = circulation;
        this.articles = articles;
    }

    public String getName() { return name; }
    public Frequency getFrequency() { return frequency; }
    public Article[] getArticles() { return articles; }
}
