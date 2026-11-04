package sp.self.learning.persistence.entities;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;

import java.util.ArrayList;
import java.util.List;

// Maps the table of contents using the id inherited from BaseElement
@Entity
public class TableOfContents extends BaseElement {
    // Stores each entry as a string in a separate table linked to this object
    @ElementCollection
    @CollectionTable(name = "table_of_contents_entries", joinColumns = @JoinColumn(name = "toc_id"))
    @Column(name = "entry_text")
    // Saves each entry's list position so it loads in the same order
    @OrderColumn(name = "entry_position")
    private List<String> entries;

    public TableOfContents() {
        entries = new ArrayList<>();
    }

    public void addEntry(String title) {
        entries.add(title);
    }

    public List<String> getEntries() {
        return List.copyOf(entries);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void render() {
        System.out.println("Table of Contents:");

        for(String entry : entries)
            System.out.println(entry);
    }
}
