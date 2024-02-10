package org.example.zecelainfo.services.implementation;

import org.example.zecelainfo.dto.TemaDTO;
import org.example.zecelainfo.models.*;
import org.example.zecelainfo.repositories.ClasaRepository;
import org.example.zecelainfo.repositories.TemaRepository;
import org.example.zecelainfo.repositories.UserClasaRepository;
import org.example.zecelainfo.repositories.UserRepository;
import org.example.zecelainfo.services.interfaces.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TemaServiceImpl implements TemaService {

    @Autowired
    private TemaRepository TemaRepository;

    @Autowired
    private ClasaRepository ClasaRepository;

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private UserClasaRepository UserClasaRepository;

    @Override
    public Optional<Tema> create(TemaDTO TemaDTO, String authenticated_email) {

        Tema tema = new Tema();
        tema.setNume(TemaDTO.getNume());
        tema.setDescriere(TemaDTO.getDescriere());
        tema.setDataInceput(TemaDTO.getDataInceput());
        tema.setDataSfarsit(TemaDTO.getDataSfarsit());


        Optional<Clasa> clasa = ClasaRepository.findById(TemaDTO.getIdClasa());

        if(clasa.isEmpty()){
            return Optional.empty();
        }

        tema.setClasa(clasa.get());

        TemaRepository.save(tema);

        return Optional.of(tema);
    }

    @Override
    public List<Tema> getAll(String authenticated_email) {

        Optional<User> user = UserRepository.findByEmail(authenticated_email);

        List<Clasa> clase = UserClasaRepository.findUserClasasByUser(user.get()).stream().map(UserClasa::getClasa).toList();

        return TemaRepository.findAll().stream().filter(tema -> clase.contains(tema.getClasa())).toList();
    }

    @Override
    public Optional<Tema> getWithId(Integer id, String authenticated_email) {

        return getAll(authenticated_email).stream().filter(entity -> entity.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Tema> update(TemaDTO TemaDTO, Integer id, String authenticated_email) {
        Optional<Tema> tema = getWithId(id, authenticated_email);
        if (tema.isPresent()){
            Tema found = tema.get();
            found.setDataInceput(TemaDTO.getDataInceput());
            found.setNume(TemaDTO.getNume());
            found.setDataSfarsit(TemaDTO.getDataSfarsit());
            found.setDescriere(TemaDTO.getDescriere());

            Optional<Clasa> clasa = ClasaRepository.findById(TemaDTO.getIdClasa());

            if (clasa.isEmpty()){
                return Optional.empty();
            }
            found.setClasa(clasa.get());

            TemaRepository.save(found);
            return Optional.of(found);
        }
        return Optional.empty();
    }

    @Override
    public void delete(Integer id, String authenticated_email) {

        Optional<Tema> tema = getWithId(id, authenticated_email);

        tema.ifPresent(value -> TemaRepository.delete(value));
    }
}
