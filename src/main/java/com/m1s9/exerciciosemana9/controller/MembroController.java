package com.m1s9.exerciciosemana9.controller;

import com.m1s9.exerciciosemana9.model.Membro;
import com.m1s9.exerciciosemana9.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membros")
public class MembroController {

    @Autowired
    private MembroRepository membroRepository;

    @PostMapping
    public ResponseEntity<Membro> criarMembro(@RequestBody Membro membro) {
        Membro novoMembro = membroRepository.save(membro);
        return ResponseEntity.ok(novoMembro);
    }
}


