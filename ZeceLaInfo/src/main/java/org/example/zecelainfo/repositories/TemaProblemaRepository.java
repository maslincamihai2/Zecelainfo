package org.example.zecelainfo.repositories;

import org.example.zecelainfo.models.TemaProblema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaProblemaRepository extends JpaRepository<TemaProblema, Integer> {
    // Custom queries if needed
}

