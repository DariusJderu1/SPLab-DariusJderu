package sp.self.learning.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

// Maps image proxies to their own table using the inherited id
@Entity
public class ImageProxy extends BaseElement implements Picture {
    // Stores the filename so the proxy can load the image when needed
    @Column(name = "name")
    private String name;

    // Keeps the loaded image in memory only
    @Transient
    private Image realImage;

    // Hibernate uses this constructor when loading a saved proxy
    protected ImageProxy()
    {
    }

    public ImageProxy(String name) {
        this.name = name;
    }

    private Image loadImage() {
        if(realImage == null)
            realImage = new Image(name);

        return realImage;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void render() {
        loadImage().render();
    }
}
