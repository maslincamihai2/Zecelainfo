package org.example.zecelainfo.services.interfaces;

import org.example.zecelainfo.dto.SolutieDTO;
import org.example.zecelainfo.models.Solutie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface SolutieService {
    Optional<Solutie> create(SolutieDTO SolutieDTO, String authenticated_email);

    List<Solutie> getAll(String authenticated_email);

    Optional<Solutie> getWithId(Integer id, String authenticated_email);
}
