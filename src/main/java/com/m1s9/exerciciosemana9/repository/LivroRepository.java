
package com.m1s9.exerciciosemana9.repository;

import com.m1s9.exerciciosemana9.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l.titulo FROM Livro l")
    List<String> buscarTitulosDosLivros();

    @Query("SELECT l.autor FROM Livro l")
    List<String> buscarAutoresDosLivros();

    @Modifying
    @Transactional
    @Query("UPDATE Livro l SET l.titulo = :titulo WHERE l.id = :id")
    int updateTituloLivro(Long id, String titulo);
}

