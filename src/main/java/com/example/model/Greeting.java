package com.example.model;

/**
 * Model class representing a greeting message.
 */
public class Greeting {

    private Long id;
    private String message;
    private String name;

    /**
     * Default constructor
     */
    public Greeting() {
    }

    /**
     * Constructor with id, message, and name
     */
    public Greeting(Long id, String message, String name) {
        this.id = id;
        this.message = message;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
