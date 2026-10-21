package sp.self.learning.model;

public class GenerateToC implements Visitor {
    private TableOfContents tableOfContents;

    public GenerateToC() {
        tableOfContents = new TableOfContents();
    }

    public TableOfContents getToC() {
        return tableOfContents;
    }

    @Override
    public void visit(Book book) {
    }

    @Override
    public void visit(Section section) {
        tableOfContents.addEntry(section.getTitle());
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
    }

    @Override
    public void visit(Paragraph paragraph) {
    }

    @Override
    public void visit(Image image) {
    }

    @Override
    public void visit(ImageProxy imageProxy) {
    }

    @Override
    public void visit(Table table) {
    }
}
