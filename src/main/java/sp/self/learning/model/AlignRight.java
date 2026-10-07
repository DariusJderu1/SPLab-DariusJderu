package sp.self.learning.model;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph) {
        System.out.println("Aligning right: " + paragraph.getText());
    }
}