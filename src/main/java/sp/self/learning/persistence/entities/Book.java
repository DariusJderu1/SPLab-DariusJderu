package sp.self.learning.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OrderColumn;

import java.util.ArrayList;
import java.util.List;

// Maps books using the id inherited through Section
@Entity
public class Book extends Section {
    // A book can have several authors and an author can write several books
    @ManyToMany
    // Stores each link between a book and an author
    @JoinTable(name = "book_authors",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id"))
    // Preserves the order in which authors were added to the book
    @OrderColumn(name = "author_position")
    private List<Author> authors;

    // Hibernate uses this constructor when loading a saved book
    protected Book()
    {
        this(null);
    }

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
