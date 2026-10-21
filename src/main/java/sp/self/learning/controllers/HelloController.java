package sp.self.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sp.self.learning.difexamples.ClientComponent;

// Registers this class as a controller whose methods return HTTP response bodies.
@RestController
public class HelloController {
    private final ClientComponent clientComponent1;
    private final ClientComponent clientComponent2;

    // Tells Spring to resolve each constructor dependency from its container.
    // Prototype scope gives us two clients; singleton scope would give us the same client twice.
    @Autowired
    public HelloController(ClientComponent clientComponent1, ClientComponent clientComponent2) {
        this.clientComponent1 = clientComponent1;
        this.clientComponent2 = clientComponent2;
    }

    // This controller is a singleton, so it keeps these injected clients across HTTP requests.
    // Handles GET requests to the root URL
    @GetMapping("/")
    public String hello() {
        return "Hello from ClientComponent 1 = " + clientComponent1
                + "\nHello from ClientComponent 2 = " + clientComponent2
                + "\nSame instance: " + (clientComponent1 == clientComponent2);
    }
}
