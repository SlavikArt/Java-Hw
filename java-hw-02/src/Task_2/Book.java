package Task_2;

import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int yearOfPublication;
    private String publisher;
    private String genre;
    private int numberOfPages;

    public Book() {
        this.title = "";
        this.author = "";
        this.yearOfPublication = 0;
        this.publisher = "";
        this.genre = "";
        this.numberOfPages = 0;
    }

    public Book(String title, String author, int yearOfPublication,
                String publisher, String genre, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.publisher = publisher;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

    public Book(String title, String author) {
        this();
        this.title = title;
        this.author = author;
    }

    public void inputData(Scanner scn) {
        System.out.print("Book Title: ");
        this.title = scn.nextLine();

        System.out.print("Author: ");
        this.author = scn.nextLine();

        System.out.print("Year of Publication: ");
        this.yearOfPublication = Integer.parseInt(scn.nextLine());

        System.out.print("Publisher: ");
        this.publisher = scn.nextLine();

        System.out.print("Genre: ");
        this.genre = scn.nextLine();

        System.out.print("Number of Pages: ");
        this.numberOfPages = Integer.parseInt(scn.nextLine());
    }

    public void printData() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year of Publication: " + yearOfPublication);
        System.out.println("Publisher: " + publisher);
        System.out.println("Genre: " + genre);
        System.out.println("Number of Pages: " + numberOfPages);
    }

    public void printData(boolean shortDescription) {
        if (shortDescription)
            System.out.println("Book: " + title + ", Author: " + author);
        else
            printData();
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public int getYearOfPublication() { return yearOfPublication; }

    public void setYearOfPublication(int yearOfPublication) { this.yearOfPublication = yearOfPublication; }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    public int getNumberOfPages() { return numberOfPages; }

    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages; }
}
