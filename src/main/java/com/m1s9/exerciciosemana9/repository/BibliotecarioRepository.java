package com.m1s9.exerciciosemana9.repository;

import com.m1s9.exerciciosemana9.model.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
}

