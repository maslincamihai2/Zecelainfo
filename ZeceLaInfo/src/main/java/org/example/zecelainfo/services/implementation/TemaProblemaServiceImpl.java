package org.example.zecelainfo.services.implementation;

import org.example.zecelainfo.dto.TemaProblemaDTO;
import org.example.zecelainfo.models.Clasa;
import org.example.zecelainfo.models.Problema;
import org.example.zecelainfo.models.Tema;
import org.example.zecelainfo.models.TemaProblema;
import org.example.zecelainfo.repositories.ProblemaRepository;
import org.example.zecelainfo.repositories.TemaProblemaRepository;
import org.example.zecelainfo.repositories.TemaRepository;
import org.example.zecelainfo.services.interfaces.TemaProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TemaProblemaServiceImpl implements TemaProblemaService {

    @Autowired
    private TemaProblemaRepository TemaProblemaRepository;

    @Autowired
    private TemaRepository TemaRepository;

    @Autowired
    private ProblemaRepository ProblemaRepository;

    @Override
    public Optional<TemaProblema> create(TemaProblemaDTO TemaProblemaDTO, String authenticated_email) {
        TemaProblema temaproblema = new TemaProblema();

        Optional<Tema> tema = TemaRepository.findById(TemaProblemaDTO.getIdTema());
        Optional<Problema> problema = ProblemaRepository.findById(TemaProblemaDTO.getIdProblema());

        if(tema.isEmpty() || problema.isEmpty()){
            return Optional.empty();
        }

        temaproblema.setProblema(problema.get());
        temaproblema.setTema(tema.get());

        TemaProblemaRepository.save(temaproblema);

        return Optional.of(temaproblema);
    }

    @Override
    public List<TemaProblema> getWithTemaId(Integer id, String authenticated_email) {
        Optional<Tema> tema = TemaRepository.findById(id);

        if (tema.isEmpty()){
            return new ArrayList<>();
        }

        return TemaProblemaRepository.findTemaProblemasByTema(tema.get());
    }

    @Override
    public void delete(TemaProblemaDTO TemaProblemaDTO, String authenticated_email) {
        Optional<Tema> tema = TemaRepository.findById(TemaProblemaDTO.getIdTema());
        Optional<Problema> problema = ProblemaRepository.findById(TemaProblemaDTO.getIdProblema());

        if(tema.isEmpty() || problema.isEmpty()){
            return;
        }

        TemaProblemaRepository.deleteTemaProblemaByTemaAndProblema(tema.get(), problema.get());
    }
}
