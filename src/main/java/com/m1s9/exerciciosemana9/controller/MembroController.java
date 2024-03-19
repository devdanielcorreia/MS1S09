package com.m1s9.exerciciosemana9.controller;

import com.m1s9.exerciciosemana9.model.Membro;
import com.m1s9.exerciciosemana9.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Membro>> listarTodosOsMembros() {
        List<Membro> membros = membroRepository.findAll();
        return ResponseEntity.ok(membros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membro> buscarMembroPorId(@PathVariable Long id) {
        Optional<Membro> membro = membroRepository.findById(id);
        if (membro.isPresent()) {
            return ResponseEntity.ok(membro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMembro(@PathVariable Long id) {
        if (!membroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        membroRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/nome")
    public ResponseEntity<?> atualizarNomeMembro(@PathVariable Long id, @RequestBody String nome) {
        int updatedRows = membroRepository.updateNomeMembro(id, nome);
        if (updatedRows > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}





