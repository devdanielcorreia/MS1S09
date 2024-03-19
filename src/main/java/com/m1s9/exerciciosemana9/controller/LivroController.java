package com.m1s9.exerciciosemana9.controller;

import com.m1s9.exerciciosemana9.model.Livro;
import com.m1s9.exerciciosemana9.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroRepository.save(livro);
        return ResponseEntity.ok(novoLivro);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarTodosOsLivros() {
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return ResponseEntity.ok(livro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        if (!livroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        livroRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/titulo")
    public ResponseEntity<Void> atualizarTituloLivro(@PathVariable Long id, @RequestBody String titulo) {
        int updatedRows = livroRepository.updateTituloLivro(id, titulo);
        if (updatedRows > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}




