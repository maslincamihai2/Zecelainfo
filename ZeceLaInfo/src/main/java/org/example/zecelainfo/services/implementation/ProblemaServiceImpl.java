package org.example.zecelainfo.services.implementation;

import org.example.zecelainfo.dto.ProblemaDTO;
import org.example.zecelainfo.models.Clasa;
import org.example.zecelainfo.models.Problema;
import org.example.zecelainfo.models.User;
import org.example.zecelainfo.models.UserClasa;
import org.example.zecelainfo.repositories.ProblemaRepository;
import org.example.zecelainfo.services.interfaces.ProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProblemaServiceImpl implements ProblemaService {

    @Autowired
    private ProblemaRepository ProblemaRepository;

    @Override
    public Optional<Problema> create(ProblemaDTO ProblemaDTO, String authenticated_email) {
        Problema problema = new Problema();
        problema.setNume(ProblemaDTO.getNume());
        problema.setCategorie(ProblemaDTO.getCategorie());
        problema.setCerinta(ProblemaDTO.getCerinta());
        problema.setDificultate(ProblemaDTO.getDificultate());
        problema.setSubcategorie(ProblemaDTO.getSubcategorie());

        ProblemaRepository.save(problema);


        return Optional.of(problema);
    }

    @Override
    public List<Problema> getAll() {
        return ProblemaRepository.findAll();
    }

    @Override
    public Optional<Problema> getWithId(Integer id) {
        return getAll().stream().filter(entity -> entity.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Problema> update(ProblemaDTO ProblemaDTO, Integer id, String authenticated_email) {
        Optional<Problema> problema = getWithId(id);
        if (problema.isPresent()){
            Problema found = problema.get();
            found.setSubcategorie(ProblemaDTO.getSubcategorie());
            found.setNume(ProblemaDTO.getNume());
            found.setDificultate(ProblemaDTO.getDificultate());
            found.setCategorie(ProblemaDTO.getCategorie());
            found.setCerinta(ProblemaDTO.getCerinta());

            ProblemaRepository.save(found);
            return Optional.of(problema.get());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Problema> delete(Integer id, String authenticated_email) {

        Optional<Problema> problema = getWithId(id);

        problema.ifPresent(value -> ProblemaRepository.delete(value));
        return Optional.empty();
    }
}
