package sp.self.learning.persistence.entities;

public class Paragraph extends BaseElement {
    private String text;
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void render() {
        if(alignStrategy == null) {
            System.out.println("Paragraph: " + text);
            return;
        }

        alignStrategy.render(this);
    }
}
