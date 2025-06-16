package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

@Test
void getUsuarioTest() throws Exception {

    mockMvc.perform(get("/usuario"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre").value("John"))
            .andExpect(jsonPath("$.apellido").value("Doe"))
            .andExpect(jsonPath("$.edad").value(30));
    }
}