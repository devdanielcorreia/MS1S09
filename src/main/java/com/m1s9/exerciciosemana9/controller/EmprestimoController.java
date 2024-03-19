package com.m1s9.exerciciosemana9.controller;

import com.m1s9.exerciciosemana9.model.Emprestimo;
import com.m1s9.exerciciosemana9.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @PostMapping
    public ResponseEntity<Emprestimo> criarEmprestimo(@RequestBody Emprestimo emprestimo) {
        Emprestimo novoEmprestimo = emprestimoRepository.save(emprestimo);
        return ResponseEntity.ok(novoEmprestimo);
    }

    @GetMapping
    public ResponseEntity<List<Emprestimo>> listarTodosOsEmprestimos() {
        List<Emprestimo> emprestimos = emprestimoRepository.findAll();
        return ResponseEntity.ok(emprestimos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscarEmprestimoPorId(@PathVariable Long id) {
        Optional<Emprestimo> emprestimo = emprestimoRepository.findById(id);
        if (emprestimo.isPresent()) {
            return ResponseEntity.ok(emprestimo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmprestimo(@PathVariable Long id) {
        if (!emprestimoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        emprestimoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/dataDevolucao")
    public ResponseEntity<?> atualizarDataDevolucaoEmprestimo(@PathVariable Long id, @RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataDevolucao) {
        int updatedRows = emprestimoRepository.updateDataDevolucaoEmprestimo(id, dataDevolucao);
        if (updatedRows > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}




