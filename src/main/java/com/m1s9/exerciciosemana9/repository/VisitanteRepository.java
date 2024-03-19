package com.m1s9.exerciciosemana9.repository;

import com.m1s9.exerciciosemana9.model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Visitante v SET v.nome = :nome WHERE v.id = :id")
    int updateNomeVisitante(Long id, String nome);
}


