package sp.self.learning.persistence.entities;

public interface Element {
    void accept(Visitor visitor);
}
