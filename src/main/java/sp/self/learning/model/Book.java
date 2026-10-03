package sp.self.learning.model;

public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println("Book title: " + title);
    }
}