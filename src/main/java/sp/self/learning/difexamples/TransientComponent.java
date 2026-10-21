package sp.self.learning.difexamples;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Marks this class for component scanning so Spring can create and manage its bean.
@Component
// Overrides the default singleton scope: each request to the container creates a new instance.
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TransientComponent {
    public TransientComponent() {
        System.out.println("TransientComponent::TransientComponent = " + this);
    }

    public void operation() {
        System.out.println("Invoked TransientComponent::operation() on " + this);
    }
}
