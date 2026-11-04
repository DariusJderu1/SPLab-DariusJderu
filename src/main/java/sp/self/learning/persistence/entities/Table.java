package sp.self.learning.persistence.entities;

public class Table extends BaseElement {
    private String title;

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
