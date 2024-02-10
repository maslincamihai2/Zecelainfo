package org.example.zecelainfo.services.implementation;

import org.example.zecelainfo.dto.SolutieDTO;
import org.example.zecelainfo.models.*;
import org.example.zecelainfo.repositories.ProblemaRepository;
import org.example.zecelainfo.repositories.SolutieRepository;
import org.example.zecelainfo.repositories.UserRepository;
import org.example.zecelainfo.services.interfaces.SolutieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class SolutieServiceImpl implements SolutieService {

    @Autowired
    private SolutieRepository SolutieRepository;

    @Autowired
    private ProblemaRepository ProblemaRepository;

    @Autowired
    private UserRepository UserRepository;

    @Override
    public Optional<Solutie> create(SolutieDTO SolutieDTO, String authenticated_email) {
        Solutie solutie = new Solutie();
        System.out.println("BEFORE");
        System.out.println(solutie.getId());
        solutie.setCod_sursa(SolutieDTO.getCodSursa());
        Optional<Problema> problema = ProblemaRepository.findById(SolutieDTO.getIdProblema());

        if(problema.isEmpty()){
            return Optional.empty();
        }

        solutie.setProblema(problema.get());

        Optional<User> user = UserRepository.findByEmail(authenticated_email);

        solutie.setUser(user.get());

        Random random = new Random();
        int punctaj = random.nextInt(101);

        solutie.setPunctaj(punctaj);

        System.out.println("AFTER");
        System.out.println(solutie.getId());

        SolutieRepository.save(solutie);

        return Optional.of(solutie);

    }

    @Override
    public List<Solutie> getAll(String authenticated_email) {
        Optional<User> user = UserRepository.findByEmail(authenticated_email);

        List<Solutie> solutii = SolutieRepository.findSolutiesByUser(user.get());

        return solutii;

    }

    @Override
    public Optional<Solutie> getWithId(Integer id, String authenticated_email) {
        return getAll(authenticated_email).stream().filter(entity -> entity.getId().equals(id)).findFirst();
    }
}
