package org.example.zecelainfo.services.implementation;

import org.example.zecelainfo.dto.TemaProblemaDTO;
import org.example.zecelainfo.models.TemaProblema;
import org.example.zecelainfo.repositories.TemaProblemaRepository;
import org.example.zecelainfo.services.interfaces.TemaProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TemaProblemaServiceImpl implements TemaProblemaService {

    @Autowired
    private TemaProblemaRepository TemaProblemaRepository;

    @Override
    public Optional<TemaProblema> create(TemaProblemaDTO TemaProblemaDTO, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<TemaProblema>> getAll(String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<TemaProblema> getWithId(Integer id, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<TemaProblema> update(TemaProblemaDTO TemaProblemaDTO, Integer id, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<TemaProblema> delete(Integer id, String authenticated_email) {
        return Optional.empty();
    }
}
