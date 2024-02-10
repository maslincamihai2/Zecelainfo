package org.example.zecelainfo.services.interfaces;

import org.example.zecelainfo.dto.TemaProblemaDTO;
import org.example.zecelainfo.models.TemaProblema;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TemaProblemaService {
    Optional<TemaProblema> create(TemaProblemaDTO TemaProblemaDTO, String authenticated_email);

    List<TemaProblema> getWithTemaId(Integer id, String authenticated_email);

    void delete(TemaProblemaDTO TemaProblemaDTO, String authenticated_email);
}
