package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    // GET: Get message
    @GetMapping("/hello")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("HelloWorld");
    }
}
