package sp.self.learning.difexamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Marks this class for component scanning so Spring can create and manage its bean.
@Component
// Creates a new client for each request to the container, including each injection.
// Remove this annotation and restart to compare with the default singleton scope.
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ClientComponent {
    private final TransientComponent tc;
    private final SingletonComponent sc;

    // Tells Spring to supply the constructor dependencies from its container.
    @Autowired
    public ClientComponent(TransientComponent tc, SingletonComponent sc) {
        this.tc = tc;
        this.sc = sc;
        System.out.println("ClientComponent::ClientComponent = " + this);
        System.out.println(" o SingletonComponent = " + sc);
        System.out.println(" o TransientComponent = " + tc);
    }

    public void operation() {
        System.out.println("Invoked ClientComponent::operation() on " + this);
        System.out.println(" o SingletonComponent = " + sc);
        System.out.println(" o TransientComponent = " + tc);
    }
}
