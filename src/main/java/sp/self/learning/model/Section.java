package sp.self.learning.model;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    protected String title;
    protected List<Element> children;

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
