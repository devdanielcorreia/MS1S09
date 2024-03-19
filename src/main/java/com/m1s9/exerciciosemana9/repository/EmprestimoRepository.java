package com.m1s9.exerciciosemana9.repository;

import com.m1s9.exerciciosemana9.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Emprestimo e SET e.dataDevolucao = :dataDevolucao WHERE e.id = :id")
    int updateDataDevolucaoEmprestimo(Long id, LocalDate dataDevolucao);
}

