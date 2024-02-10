package org.example.zecelainfo.repositories;

import org.example.zecelainfo.models.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Integer> {
    // Custom queries if needed
}

