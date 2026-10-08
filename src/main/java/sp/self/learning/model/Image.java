package sp.self.learning.model;

import java.util.concurrent.TimeUnit;

public class Image implements Picture {
    private String name;

    public Image(String name) {
        this.name = name;

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + name);
    }
}