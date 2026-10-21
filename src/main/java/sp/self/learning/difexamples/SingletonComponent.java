package sp.self.learning.difexamples;

import org.springframework.stereotype.Component;

// Marks this class for component scanning so Spring can create and manage its bean.
// The default scope is singleton: one instance per bean definition per Spring container.
@Component
public class SingletonComponent {
    public SingletonComponent() {
        System.out.println("SingletonComponent::SingletonComponent = " + this);
    }

    public void operation() {
        System.out.println("Invoked SingletonComponent::operation() on " + this);
    }
}
