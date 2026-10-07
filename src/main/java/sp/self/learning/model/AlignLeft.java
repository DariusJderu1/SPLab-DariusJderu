package sp.self.learning.model;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph) {
        System.out.println("Aligning left: " + paragraph.getText());
    }
}