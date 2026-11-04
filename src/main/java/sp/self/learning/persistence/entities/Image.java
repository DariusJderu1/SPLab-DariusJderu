package sp.self.learning.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.concurrent.TimeUnit;

// Maps images to their own table linked to BaseElement by the inherited id
@Entity
public class Image extends BaseElement implements Picture {
    // Stores the image filename in the name column
    @Column(name = "name")
    private String name;

    // Lets Hibernate load an image record without running the five-second delay
    protected Image()
    {
    }

    public Image(String name) {
        this.name = name;

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void render() {
        System.out.println("Image with name: " + name);
    }
}
