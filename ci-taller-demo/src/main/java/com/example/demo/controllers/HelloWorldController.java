package com.example.demo.controllers;

import com.example.demo.models.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloWorldController {

    // GET: Get message
    @GetMapping("/usuario")
    public ResponseEntity<Usuario> getUsuario() {
      Usuario usuario = new Usuario("John","Doe", 30);
        return ResponseEntity.ok(usuario);
    }
}
