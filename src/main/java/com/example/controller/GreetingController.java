package com.example.controller;

import com.example.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * REST Controller for greeting endpoints.
 */
@RestController
@RequestMapping("/api")
public class GreetingController {

    private static final String DEFAULT_GREETING = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final List<Greeting> greetings = new ArrayList<>();

    public GreetingController() {
        // Pre-load some sample greetings
        greetings.add(new Greeting(counter.incrementAndGet(), "Welcome to our application!", "System"));
        greetings.add(new Greeting(counter.incrementAndGet(), "Good morning, Alice!", "Alice"));
        greetings.add(new Greeting(counter.incrementAndGet(), "Hey there, Bob!", "Bob"));
        greetings.add(new Greeting(counter.incrementAndGet(), "Greetings, Charlie!", "Charlie"));
        greetings.add(new Greeting(counter.incrementAndGet(), "Hi, Diana! Have a great day!", "Diana"));
        greetings.add(new Greeting(counter.incrementAndGet(), "Hello, Eve! Welcome aboard!", "Eve"));
        greetings.add(new Greeting(counter.incrementAndGet(), "Bonjour, Frank!", "Frank"));
        greetings.add(new Greeting(counter.incrementAndGet(), "Hola, Grace!", "Grace"));
        greetings.add(new Greeting(counter.incrementAndGet(), "Namaste, Henry!", "Henry"));
        greetings.add(new Greeting(counter.incrementAndGet(), "Salutations, Ivy!", "Ivy"));
    }

    /**
     * Get a greeting for a specific name
     * 
     * @param name the name to greet
     * @return a greeting object
     */
    @GetMapping("/greeting")
    public Greeting getGreeting(
            @RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = new Greeting(
                counter.incrementAndGet(),
                String.format(DEFAULT_GREETING, name),
                name
        );
        greetings.add(greeting);
        return greeting;
    }

    /**
     * Get a simple greeting message
     * 
     * @return a greeting message
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Welcome to the Greeting Web Application!";
    }

    /**
     * Get a greeting with a custom template
     * 
     * @param name the name to greet
     * @param template the greeting template
     * @return a greeting object
     */
    @GetMapping("/custom-greeting")
    public Greeting getCustomGreeting(
            @RequestParam(value = "name", defaultValue = "Friend") String name,
            @RequestParam(value = "template", defaultValue = "Hello, %s!") String template) {
        Greeting greeting = new Greeting(
                counter.incrementAndGet(),
                String.format(template, name),
                name
        );
        greetings.add(greeting);
        return greeting;
    }

    /**
     * Get all greetings stored
     * 
     * @return list of all greetings
     */
    @GetMapping("/greetings")
    public List<Greeting> getAllGreetings() {
        return greetings;
    }

    /**
     * Create a new greeting
     * 
     * @param greeting the greeting object to create
     * @return the created greeting object
     */
    @PostMapping("/greeting")
    public Greeting createGreeting(@RequestBody Greeting greeting) {
        greeting.setId(counter.incrementAndGet());
        greetings.add(greeting);
        return greeting;
    }

    /**
     * Delete all greetings
     */
    @DeleteMapping("/greetings")
    public String clearAllGreetings() {
        int size = greetings.size();
        greetings.clear();
        return "Cleared " + size + " greeting(s)";
    }

}
