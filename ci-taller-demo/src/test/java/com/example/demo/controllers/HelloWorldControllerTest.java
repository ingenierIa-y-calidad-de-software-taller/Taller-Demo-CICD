package com.example.demo.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /hello should return the default message")
    void testGetMessage() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world"));
    }

    @Test
    @DisplayName("POST /hello should create a new message")
    void testCreateMessage() throws Exception {
        mockMvc.perform(post("/hello")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("Hello world"))
                .andExpect(status().isCreated())
                .andExpect(content().string("Message created"));
    }

    @Test
    @DisplayName("PUT /hello should update the message")
    void testUpdateMessage() throws Exception {
        mockMvc.perform(put("/hello")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("Nuevo mensaje"))
                .andExpect(status().isOk())
                .andExpect(content().string("Message updated"));
    }

    @Test
    @DisplayName("PATCH /hello should patch the message")
    void testPatchMessage() throws Exception {
        mockMvc.perform(patch("/hello")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("parche"))
                .andExpect(status().isOk())
                .andExpect(content().string("Message patched"));
    }

    @Test
    @DisplayName("DELETE /hello should delete the message")
    void testDeleteMessage() throws Exception {
        mockMvc.perform(delete("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Message deleted"));
    }
}
