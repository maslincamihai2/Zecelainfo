package org.example.zecelainfo.services.interfaces;

import org.example.zecelainfo.dto.SolutieDTO;
import org.example.zecelainfo.models.Solutie;

import java.util.ArrayList;
import java.util.Optional;

public interface SolutieService {
    Optional<Solutie> create(SolutieDTO SolutieDTO, String authenticated_email);

    Optional<ArrayList<Solutie>> getAll(String authenticated_email);

    Optional<Solutie> getWithId(Integer id, String authenticated_email);

    Optional<Solutie> update(SolutieDTO SolutieDTO, Integer id, String authenticated_email);

    Optional<Solutie> delete(Integer id, String authenticated_email);
}
