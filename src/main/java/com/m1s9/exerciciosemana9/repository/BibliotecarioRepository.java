package com.m1s9.exerciciosemana9.repository;

import com.m1s9.exerciciosemana9.model.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Bibliotecario b SET b.email = :email WHERE b.id = :id")
    int updateEmailBibliotecario(Long id, String email);
}


