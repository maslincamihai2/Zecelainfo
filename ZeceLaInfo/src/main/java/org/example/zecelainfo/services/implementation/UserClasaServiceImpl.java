package org.example.zecelainfo.services.implementation;

import org.example.zecelainfo.dto.UserClasaDTO;
import org.example.zecelainfo.models.UserClasa;
import org.example.zecelainfo.repositories.UserClasaRepository;
import org.example.zecelainfo.services.interfaces.UserClasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserClasaServiceImpl implements UserClasaService {

    @Autowired
    private UserClasaRepository UserClasaRepository;

    @Override
    public Optional<UserClasa> create(UserClasaDTO UserClasaDTO, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<UserClasa>> getAll(String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<UserClasa> getWithId(Integer id, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<UserClasa> update(UserClasaDTO UserClasaDTO, Integer id, String authenticated_email) {
        return Optional.empty();
    }

    @Override
    public Optional<UserClasa> delete(Integer id, String authenticated_email) {
        return Optional.empty();
    }
}
