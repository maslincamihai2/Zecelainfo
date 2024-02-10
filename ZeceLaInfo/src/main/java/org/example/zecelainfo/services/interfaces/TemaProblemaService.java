package org.example.zecelainfo.services.interfaces;

import org.example.zecelainfo.dto.TemaProblemaDTO;
import org.example.zecelainfo.models.TemaProblema;

import java.util.ArrayList;
import java.util.Optional;

public interface TemaProblemaService {
    Optional<TemaProblema> create(TemaProblemaDTO TemaProblemaDTO, String authenticated_email);

    Optional<ArrayList<TemaProblema>> getAll(String authenticated_email);

    Optional<TemaProblema> getWithId(Integer id, String authenticated_email);

    Optional<TemaProblema> update(TemaProblemaDTO TemaProblemaDTO, Integer id, String authenticated_email);

    Optional<TemaProblema> delete(Integer id, String authenticated_email);
}
