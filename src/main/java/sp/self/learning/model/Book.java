package sp.self.learning.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private List<Element> content;

    public Book(String title) {
        this.title = title;
        authors = new ArrayList<>();
        content = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        content.add(element);
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");

        for(Author author : authors)
            author.print();

        for(Element element : content)
            element.print();
    }
}