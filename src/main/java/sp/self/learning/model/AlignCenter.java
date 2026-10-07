package sp.self.learning.model;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph) {
        System.out.println("Aligning center: " + paragraph.getText());
    }
}
