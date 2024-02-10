package org.example.zecelainfo.services.interfaces;

import org.example.zecelainfo.dto.UserClasaDTO;
import org.example.zecelainfo.models.UserClasa;

import java.util.ArrayList;
import java.util.Optional;

public interface UserClasaService {
    Optional<UserClasa> create(UserClasaDTO UserClasaDTO, String authenticated_email);

    Optional<ArrayList<UserClasa>> getAll(String authenticated_email);

    Optional<UserClasa> getWithId(Integer id, String authenticated_email);

    Optional<UserClasa> update(UserClasaDTO UserClasaDTO, Integer id, String authenticated_email);

    Optional<UserClasa> delete(Integer id, String authenticated_email);
}
