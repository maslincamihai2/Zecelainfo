package org.example.zecelainfo.services.interfaces;

import org.example.zecelainfo.dto.TemaDTO;
import org.example.zecelainfo.models.Tema;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TemaService {
    Optional<Tema> create(TemaDTO TemaDTO, String authenticated_email);

    List<Tema> getAll(String authenticated_email);

    Optional<Tema> getWithId(Integer id, String authenticated_email);

    Optional<Tema> update(TemaDTO TemaDTO, Integer id, String authenticated_email);

    void delete(Integer id, String authenticated_email);
}
