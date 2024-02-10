package org.example.zecelainfo.repositories;

import org.example.zecelainfo.models.Problema;
import org.example.zecelainfo.models.Tema;
import org.example.zecelainfo.models.TemaProblema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemaProblemaRepository extends JpaRepository<TemaProblema, Integer> {
    // Custom queries if needed
    List<TemaProblema> findTemaProblemasByTema(Tema tema);
    void deleteTemaProblemaByTemaAndProblema(Tema tema, Problema problema);
}

