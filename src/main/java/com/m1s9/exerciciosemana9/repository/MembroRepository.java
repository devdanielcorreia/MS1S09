package com.m1s9.exerciciosemana9.repository;

import com.m1s9.exerciciosemana9.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Membro m SET m.nome = :nome WHERE m.id = :id")
    int updateNomeMembro(Long id, String nome);
}




