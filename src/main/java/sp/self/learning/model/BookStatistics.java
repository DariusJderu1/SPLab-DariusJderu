package sp.self.learning.model;

public class BookStatistics implements Visitor {
    private int numberOfImages;
    private int numberOfTables;
    private int numberOfParagraphs;

    @Override
    public void visit(Book book) {
    }

    @Override
    public void visit(Section section) {
    }

    @Override
    public void visit(Paragraph paragraph) {
        numberOfParagraphs++;
    }

    @Override
    public void visit(Image image) {
        numberOfImages++;
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        numberOfImages++;
    }

    @Override
    public void visit(Table table) {
        numberOfTables++;
    }

    public void printStatistics() {
        System.out.println("Book Statistics:");
        System.out.println("*** Number of images: " + numberOfImages);
        System.out.println("*** Number of tables: " + numberOfTables);
        System.out.println("*** Number of paragraphs: " + numberOfParagraphs);
    }
}
