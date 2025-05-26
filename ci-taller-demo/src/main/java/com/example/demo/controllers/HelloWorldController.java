package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello") // Prefijo común para todos los endpoints
public class HelloWorldController {

    private String message = "Hello world";

    // GET: Obtener el mensaje
    @GetMapping
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok(message);
    }

    // POST: Crear un nuevo mensaje
    @PostMapping
    public ResponseEntity<String> createMessage(@RequestBody String newMessage) {
        this.message = newMessage;
        return new ResponseEntity<>("Message created", HttpStatus.CREATED);
    }

    // PUT: Reemplazar completamente el mensaje
    @PutMapping
    public ResponseEntity<String> updateMessage(@RequestBody String updatedMessage) {
        this.message = updatedMessage;
        return ResponseEntity.ok("Message updated");
    }

    // PATCH: Actualizar parcialmente el mensaje
    @PatchMapping
    public ResponseEntity<String> patchMessage(@RequestBody String partialMessage) {
        this.message += " " + partialMessage;
        return ResponseEntity.ok("Message patched");
    }

    // DELETE: Borrar el mensaje
    @DeleteMapping
    public ResponseEntity<String> deleteMessage() {
        this.message = "";
        return ResponseEntity.ok("Message deleted");
    }
}