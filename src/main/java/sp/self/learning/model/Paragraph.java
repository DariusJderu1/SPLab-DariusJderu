package sp.self.learning.model;

public class Paragraph implements Element {
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
    public void print() {
        if(alignStrategy == null) {
            System.out.println("Paragraph: " + text);
            return;
        }

        alignStrategy.render(this);
    }
}
