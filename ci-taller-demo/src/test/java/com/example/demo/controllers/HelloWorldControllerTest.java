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
    @DisplayName("POST /hello should create a new message and retrieve it")
    void testCreateMessage() throws Exception {
        mockMvc.perform(post("/hello")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("Hello world"))
                .andExpect(status().isCreated())
                .andExpect(content().string("Message created"));

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world"));
    }

    @Test
    @DisplayName("PUT /hello should update the message and retrieve it")
    void testUpdateMessage() throws Exception {
        mockMvc.perform(put("/hello")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("Mensaje actualizado"))
                .andExpect(status().isOk())
                .andExpect(content().string("Message updated"));

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Mensaje actualizado"));
    }

    @Test
    @DisplayName("PATCH /hello should patch the message and retrieve it")
    void testPatchMessage() throws Exception {
        // Establecer un mensaje base
        mockMvc.perform(post("/hello")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("Base"))
                .andExpect(status().isCreated());

        // Agregar con PATCH
        mockMvc.perform(patch("/hello")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("extra"))
                .andExpect(status().isOk())
                .andExpect(content().string("Message patched"));

        // Verificar resultado
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Base extra"));
    }

    @Test
    @DisplayName("DELETE /hello should clear the message")
    void testDeleteMessage() throws Exception {
        // Establecer un mensaje antes de borrar
        mockMvc.perform(post("/hello")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("Para borrar"))
                .andExpect(status().isCreated());

        mockMvc.perform(delete("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Message deleted"));

        // Verificar que el mensaje fue borrado
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}
