package com.m1s9.exerciciosemana9.controller;

import com.m1s9.exerciciosemana9.model.Emprestimo;
import com.m1s9.exerciciosemana9.model.Livro;
import com.m1s9.exerciciosemana9.model.Membro;
import com.m1s9.exerciciosemana9.repository.EmprestimoRepository;
import com.m1s9.exerciciosemana9.repository.LivroRepository;
import com.m1s9.exerciciosemana9.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private MembroRepository membroRepository;

    @PostMapping
    public ResponseEntity<?> criarEmprestimo(@RequestBody EmprestimoInput input) {
        Optional<Livro> livro = livroRepository.findById(input.getIdLivro());
        Optional<Membro> membro = membroRepository.findById(input.getIdMembro());

        if (!livro.isPresent() || !membro.isPresent()) {
            return ResponseEntity.badRequest().body("Livro ou Membro não encontrado.");
        }

        Emprestimo novoEmprestimo = new Emprestimo();
        novoEmprestimo.setLivro(livro.get());
        novoEmprestimo.setMembro(membro.get());
        novoEmprestimo.setDataEmprestimo(input.getDataEmprestimo());
        novoEmprestimo.setDataDevolucao(input.getDataDevolucao());

        emprestimoRepository.save(novoEmprestimo);

        return ResponseEntity.ok(novoEmprestimo);
    }

    private static class EmprestimoInput {
        private Long idLivro;
        private Long idMembro;
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private LocalDate dataEmprestimo;
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private LocalDate dataDevolucao;

        // Getters
        public Long getIdLivro() {
            return idLivro;
        }

        public Long getIdMembro() {
            return idMembro;
        }

        public LocalDate getDataEmprestimo() {
            return dataEmprestimo;
        }

        public LocalDate getDataDevolucao() {
            return dataDevolucao;
        }

        // Setters
        public void setIdLivro(Long idLivro) {
            this.idLivro = idLivro;
        }

        public void setIdMembro(Long idMembro) {
            this.idMembro = idMembro;
        }

        public void setDataEmprestimo(LocalDate dataEmprestimo) {
            this.dataEmprestimo = dataEmprestimo;
        }

        public void setDataDevolucao(LocalDate dataDevolucao) {
            this.dataDevolucao = dataDevolucao;
        }
    }
}


