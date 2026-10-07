package sp.self.learning.model;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    private String title;
    private List<Element> children;

    public Section(String title) {
        this.title = title;
        children = new ArrayList<>();
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

    @Override
    public void print() {
        System.out.println(title);

        for(Element child : children)
            child.print();
    }
}
