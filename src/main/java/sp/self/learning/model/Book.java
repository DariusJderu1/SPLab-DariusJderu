package sp.self.learning.model;

import java.util.ArrayList;
import java.util.List;

public class Book extends Section {
    private List<Author> authors;

    public Book(String title) {
        super(title);
        authors = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        add(element);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

        for(Element element : children)
            element.accept(visitor);
    }

    @Override
    public void render() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");

        for(Author author : authors)
            author.print();
    }
}
