package com.m1s9.exerciciosemana9.controller;

import com.m1s9.exerciciosemana9.model.Bibliotecario;
import com.m1s9.exerciciosemana9.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Bibliotecario>> listarTodosOsBibliotecarios() {
        List<Bibliotecario> bibliotecarios = bibliotecarioRepository.findAll();
        return ResponseEntity.ok(bibliotecarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bibliotecario> buscarBibliotecarioPorId(@PathVariable Long id) {
        Optional<Bibliotecario> bibliotecario = bibliotecarioRepository.findById(id);
        if (bibliotecario.isPresent()) {
            return ResponseEntity.ok(bibliotecario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBibliotecario(@PathVariable Long id) {
        if (!bibliotecarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bibliotecarioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/email")
    public ResponseEntity<?> atualizarEmailBibliotecario(@PathVariable Long id, @RequestBody String email) {
        int updatedRows = bibliotecarioRepository.updateEmailBibliotecario(id, email);
        if (updatedRows > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}




