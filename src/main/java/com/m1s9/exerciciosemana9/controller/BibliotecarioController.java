package com.m1s9.exerciciosemana9.controller;

import com.m1s9.exerciciosemana9.model.Bibliotecario;
import com.m1s9.exerciciosemana9.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bibliotecarios")
public class BibliotecarioController {

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    @PostMapping
    public ResponseEntity<Bibliotecario> criarBibliotecario(@RequestBody Bibliotecario bibliotecario) {
        Bibliotecario novoBibliotecario = bibliotecarioRepository.save(bibliotecario);
        return ResponseEntity.ok(novoBibliotecario);
    }
}

