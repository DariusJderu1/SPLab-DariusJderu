package sp.self.learning.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

// Maps book tables as entities using the inherited id
@Entity
// Uses a database table name that avoids the SQL keyword TABLE
@jakarta.persistence.Table(name = "book_table")
public class Table extends BaseElement {
    // Stores the title of the book table
    @Column(name = "title")
    private String title;

    // Hibernate uses this constructor when loading a saved table
    protected Table()
    {
    }

    public Table(String title) {
        this.title = title;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void render() {
        System.out.println("Table with title: " + title);
    }
}
