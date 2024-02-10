package org.example.zecelainfo.services.interfaces;

import org.example.zecelainfo.dto.ProblemaDTO;
import org.example.zecelainfo.models.Problema;

import java.util.ArrayList;
import java.util.Optional;

public interface ProblemaService {
    Optional<Problema> create(ProblemaDTO ProblemaDTO, String authenticated_email);

    Optional<ArrayList<Problema>> getAll(String authenticated_email);

    Optional<Problema> getWithId(Integer id, String authenticated_email);

    Optional<Problema> update(ProblemaDTO ProblemaDTO, Integer id, String authenticated_email);

    Optional<Problema> delete(Integer id, String authenticated_email);
}
