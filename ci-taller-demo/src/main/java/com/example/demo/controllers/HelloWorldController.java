package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    // GET: Obtener el mensaje
    @GetMapping("/hello")
    public ResponseEntity<String> Get() {
        return ResponseEntity.ok("HelloWorld");
    }
}
