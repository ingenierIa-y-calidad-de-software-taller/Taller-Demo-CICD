package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello") // Prefijo común para todos los endpoints
public class HelloWorldController {

    // GET: Obtener el mensaje
    @GetMapping("/hello")
    public String simple() {
        return "HelloWorld";
    }
}