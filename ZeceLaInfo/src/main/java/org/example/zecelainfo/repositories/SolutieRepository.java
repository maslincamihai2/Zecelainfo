package org.example.zecelainfo.repositories;

import org.example.zecelainfo.models.Solutie;
import org.example.zecelainfo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SolutieRepository extends JpaRepository<Solutie, Integer> {
    List<Solutie> findSolutiesByUser(User user);
}

