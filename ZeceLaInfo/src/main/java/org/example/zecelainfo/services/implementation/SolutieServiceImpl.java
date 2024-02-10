package org.example.zecelainfo.services.implementation;

import org.example.zecelainfo.dto.SolutieDTO;
import org.example.zecelainfo.models.Solutie;
import org.example.zecelainfo.repositories.SolutieRepository;
import org.example.zecelainfo.services.interfaces.SolutieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SolutieServiceImpl implements SolutieService {

    @Autowired
    private SolutieRepository SolutieRepository;

    @Override
    public Optional<Solutie> create(SolutieDTO SolutieDTO, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<Solutie>> getAll(String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<Solutie> getWithId(Integer id, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<Solutie> update(SolutieDTO SolutieDTO, Integer id, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<Solutie> delete(Integer id, String authenticated_email) {
        return Optional.empty();
    }
}
