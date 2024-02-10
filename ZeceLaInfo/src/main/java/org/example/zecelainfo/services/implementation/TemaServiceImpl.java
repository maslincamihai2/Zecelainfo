package org.example.zecelainfo.services.implementation;

import org.example.zecelainfo.dto.TemaDTO;
import org.example.zecelainfo.models.Tema;
import org.example.zecelainfo.repositories.TemaRepository;
import org.example.zecelainfo.services.interfaces.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TemaServiceImpl implements TemaService {

    @Autowired
    private TemaRepository TemaRepository;

    @Override
    public Optional<Tema> create(TemaDTO TemaDTO, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<Tema>> getAll(String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<Tema> getWithId(Integer id, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<Tema> update(TemaDTO TemaDTO, Integer id, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<Tema> delete(Integer id, String authenticated_email) {
        return Optional.empty();
    }
}
