package com.m1s9.exerciciosemana9.repository;

import com.m1s9.exerciciosemana9.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}

