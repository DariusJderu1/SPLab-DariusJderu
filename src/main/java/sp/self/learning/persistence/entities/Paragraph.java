package sp.self.learning.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

// Maps paragraphs to their own table linked to BaseElement by the inherited id
@Entity
public class Paragraph extends BaseElement {
    // Stores the paragraph content in the text column
    @Column(name = "text")
    private String text;

    // Keeps the rendering strategy out of the database
    @Transient
    private AlignStrategy alignStrategy;

    // Hibernate uses this constructor when loading a paragraph
    protected Paragraph()
    {
    }

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
