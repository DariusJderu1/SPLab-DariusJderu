package sp.self.learning.persistence.entities;

public interface Visitor {
    void visit(Book book);

    void visit(Section section);

    void visit(TableOfContents tableOfContents);

    void visit(Paragraph paragraph);

    void visit(Image image);

    void visit(ImageProxy imageProxy);

    void visit(Table table);
}
