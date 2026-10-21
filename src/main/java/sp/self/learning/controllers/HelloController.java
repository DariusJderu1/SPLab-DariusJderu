package sp.self.learning.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Registers this class as a controller whose methods return HTTP response bodies.
@RestController
public class HelloController {
    // Handles GET requests to the root URL
    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot";
    }
}
