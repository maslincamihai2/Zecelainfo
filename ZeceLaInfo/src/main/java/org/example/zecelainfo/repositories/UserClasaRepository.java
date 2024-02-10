package org.example.zecelainfo.repositories;

import org.example.zecelainfo.models.UserClasa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserClasaRepository extends JpaRepository<UserClasa, Integer> {
    // Custom queries if needed
}

