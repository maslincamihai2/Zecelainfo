package org.example.zecelainfo.services.interfaces;

import org.example.zecelainfo.dto.ClasaDTO;
import org.example.zecelainfo.models.Clasa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ClasaService {
    Optional<Clasa> create(ClasaDTO ClasaDTO, String authenticated_email);

    List<Clasa> getAll(String authenticated_email);

    Optional<Clasa> getWithId(Integer id, String authenticated_email);

    Optional<Clasa> update(ClasaDTO ClasaDTO, Integer id, String authenticated_email);

    void delete(Integer id, String authenticated_email);
}
