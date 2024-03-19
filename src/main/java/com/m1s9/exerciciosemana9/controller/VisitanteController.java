package com.m1s9.exerciciosemana9.controller;

import com.m1s9.exerciciosemana9.model.Visitante;
import com.m1s9.exerciciosemana9.repository.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visitantes")
public class VisitanteController {

    @Autowired
    private VisitanteRepository visitanteRepository;

    @PostMapping
    public ResponseEntity<Visitante> criarVisitante(@RequestBody Visitante visitante) {
        Visitante novoVisitante = visitanteRepository.save(visitante);
        return ResponseEntity.ok(novoVisitante);
    }

    @GetMapping
    public ResponseEntity<List<Visitante>> listarTodosOsVisitantes() {
        List<Visitante> visitantes = visitanteRepository.findAll();
        return ResponseEntity.ok(visitantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitante> buscarVisitantePorId(@PathVariable Long id) {
        Optional<Visitante> visitante = visitanteRepository.findById(id);
        if (visitante.isPresent()) {
            return ResponseEntity.ok(visitante.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVisitante(@PathVariable Long id) {
        if (!visitanteRepository.existsById(id)) {
            return ResponseEntity.notFound
                    ().build();
        }
        visitanteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

