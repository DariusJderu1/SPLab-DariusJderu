package sp.self.learning.model;

import java.util.ArrayList;
import java.util.List;

public class TableOfContents implements Element {
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
