package org.example.zecelainfo.repositories;

import org.example.zecelainfo.models.Solutie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutieRepository extends JpaRepository<Solutie, Integer> {
    // Custom queries if needed
}

