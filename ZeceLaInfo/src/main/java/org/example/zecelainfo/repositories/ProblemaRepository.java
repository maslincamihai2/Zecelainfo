package org.example.zecelainfo.repositories;

import org.example.zecelainfo.models.Problema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemaRepository extends JpaRepository<Problema, Integer> {
    // Custom queries if needed
}

