package org.example.zecelainfo.services.implementation;

import org.example.zecelainfo.dto.ProblemaDTO;
import org.example.zecelainfo.models.Problema;
import org.example.zecelainfo.repositories.ProblemaRepository;
import org.example.zecelainfo.services.interfaces.ProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProblemaServiceImpl implements ProblemaService {

    @Autowired
    private ProblemaRepository ProblemaRepository;

    @Override
    public Optional<Problema> create(ProblemaDTO ProblemaDTO, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<Problema>> getAll(String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<Problema> getWithId(Integer id, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<Problema> update(ProblemaDTO ProblemaDTO, Integer id, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<Problema> delete(Integer id, String authenticated_email) {
        return Optional.empty();
    }
}
