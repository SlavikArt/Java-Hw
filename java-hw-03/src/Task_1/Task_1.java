package Task_1;

public class Task_1 {
    public static void main(String[] args) {
        Human author = new Human("Іван", "Коваль", "15.03.1980");
        Article[] articles = {
                new Article(author, "Програмування на Java", 4.8),
                new Article(author, "Штучний інтелект", 4.5)
        };
        Magazine mag = new Magazine("IT Світ", Frequency.MONTHLY,
                "10.10.2023", 5000, articles);

        System.out.println("Журнал: " + mag.getName());
        System.out.println("Періодичність: " + mag.getFrequency());
        System.out.println("Статті:");
        for (int i = 0; i < articles.length; i++)
            System.out.println(" - " + articles[i].getTitle()
                    + " (" + articles[i].getRating() + ")");
    }
}
