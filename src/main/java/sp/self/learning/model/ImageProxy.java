package sp.self.learning.model;

public class ImageProxy implements Picture {
    private String name;
    private Image realImage;

    public ImageProxy(String name) {
        this.name = name;
    }

    private Image loadImage() {
        if(realImage == null)
            realImage = new Image(name);

        return realImage;
    }

    @Override
    public void print() {
        loadImage().print();
    }
}
