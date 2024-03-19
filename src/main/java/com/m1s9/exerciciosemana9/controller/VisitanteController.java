package com.m1s9.exerciciosemana9.controller;

import com.m1s9.exerciciosemana9.model.Visitante;
import com.m1s9.exerciciosemana9.repository.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}

