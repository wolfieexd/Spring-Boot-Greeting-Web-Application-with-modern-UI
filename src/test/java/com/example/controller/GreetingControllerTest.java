package com.example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for the GreetingController
 */
@WebMvcTest(GreetingController.class)
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        // Clear greetings before each test
        try {
            mockMvc.perform(delete("/api/greetings"));
        } catch (Exception e) {
            // Ignore
        }
    }

    @Test
    public void testSayHello() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome")));
    }

    @Test
    public void testGetGreetingWithDefaultName() throws Exception {
        mockMvc.perform(get("/api/greeting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("World"))
                .andExpect(jsonPath("$.message").value("Hello, World!"))
                .andExpect(jsonPath("$.id").isNumber());
    }

    @Test
    public void testGetGreetingWithCustomName() throws Exception {
        mockMvc.perform(get("/api/greeting?name=Alice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"))
                .andExpect(jsonPath("$.message").value("Hello, Alice!"));
    }

    @Test
    public void testGetCustomGreeting() throws Exception {
        mockMvc.perform(get("/api/custom-greeting?name=Bob&template=Hi, %s!"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Bob"))
                .andExpect(jsonPath("$.message").value("Hi, Bob!"));
    }

    @Test
    public void testGetAllGreetings() throws Exception {
        // Create some greetings first
        mockMvc.perform(get("/api/greeting?name=Alice"));
        mockMvc.perform(get("/api/greeting?name=Bob"));

        // Get all greetings
        mockMvc.perform(get("/api/greetings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testCreateGreeting() throws Exception {
        mockMvc.perform(post("/api/greeting")
                .contentType("application/json")
                .content("{\"message\":\"Hello\",\"name\":\"Test\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.message").value("Hello"))
                .andExpect(jsonPath("$.name").value("Test"));
    }

    @Test
    public void testDeleteAllGreetings() throws Exception {
        // Create some greetings first
        mockMvc.perform(get("/api/greeting?name=Alice"));
        mockMvc.perform(get("/api/greeting?name=Bob"));

        // Delete all
        mockMvc.perform(delete("/api/greetings"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Cleared")));

        // Verify all deleted
        mockMvc.perform(get("/api/greetings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
