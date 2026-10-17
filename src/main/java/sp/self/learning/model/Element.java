package sp.self.learning.model;

public interface Element {
    void print();

    void accept(Visitor visitor);
}
