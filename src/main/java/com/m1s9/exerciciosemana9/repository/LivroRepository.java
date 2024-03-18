
package com.m1s9.exerciciosemana9.repository;

import com.m1s9.exerciciosemana9.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l.titulo FROM Livro l")
    List<String> buscarTitulosDosLivros();

    @Query("SELECT l.autor FROM Livro l")
    List<String> buscarAutoresDosLivros();

}
