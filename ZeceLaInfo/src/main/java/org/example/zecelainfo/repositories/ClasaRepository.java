package org.example.zecelainfo.repositories;

import org.example.zecelainfo.models.Clasa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasaRepository extends JpaRepository<Clasa, Integer> {
    // Custom queries if needed
}
