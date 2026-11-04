package sp.self.learning.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;

import java.util.ArrayList;
import java.util.List;

// Maps sections using the id inherited from BaseElement
@Entity
public class Section extends BaseElement {
    // Stores the section title
    @Column(name = "title")
    protected String title;

    // Element is an interface, so the relationship targets the BaseElement entity
    @OneToMany(targetEntity = BaseElement.class)
    // Links each section to its children by their ids
    @JoinTable(name = "section_children",
        joinColumns = @JoinColumn(name = "section_id"),
        inverseJoinColumns = @JoinColumn(name = "child_id"))
    // Stores each child's position in the section
    @OrderColumn(name = "child_position")
    protected List<Element> children;

    // Hibernate uses this constructor when loading a saved section
    protected Section()
    {
        this(null);
    }

    public Section(String title) {
        this.title = title;
        children = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void add(Element element) {
        children.add(element);
    }

    public void remove(Element element) {
        children.remove(element);
    }

    public Element get(int index) {
        return children.get(index);
    }

    public void render() {
        System.out.println(title);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

        for(Element child : children)
            child.accept(visitor);
    }
}
