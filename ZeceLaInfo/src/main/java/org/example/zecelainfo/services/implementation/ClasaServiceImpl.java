package org.example.zecelainfo.services.implementation;

import org.example.zecelainfo.dto.ClasaDTO;
import org.example.zecelainfo.models.Clasa;
import org.example.zecelainfo.models.User;
import org.example.zecelainfo.models.UserClasa;
import org.example.zecelainfo.repositories.ClasaRepository;
import org.example.zecelainfo.repositories.UserClasaRepository;
import org.example.zecelainfo.repositories.UserRepository;
import org.example.zecelainfo.services.interfaces.ClasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClasaServiceImpl implements ClasaService {

    @Autowired
    private ClasaRepository ClasaRepository;

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    public UserClasaRepository UserClasaRepository;

    @Override
    public Optional<Clasa> create(ClasaDTO ClasaDTO, String authenticated_email) {
        Clasa clasa = new Clasa();
        clasa.setJudet(ClasaDTO.getJudet());
        clasa.setLocalitate(ClasaDTO.getLocalitate());
        clasa.setNume(ClasaDTO.getNume());
        clasa.setUnitateScolara(ClasaDTO.getUnitateScolara());
        clasa.setNivel(ClasaDTO.getNivel());

        ClasaRepository.save(clasa);

        Optional<User> user = UserRepository.findByEmail(authenticated_email);

        UserClasa userClasa = new UserClasa();
        userClasa.setUser(user.get());
        userClasa.setClasa(clasa);

        UserClasaRepository.save(userClasa);

        return Optional.of(clasa);
    }

    @Override
    public List<Clasa> getAll(String authenticated_email) {
        Optional<User> user = UserRepository.findByEmail(authenticated_email);

        List<UserClasa> user_classes = UserClasaRepository.findUserClasasByUser(user.get());
        List<Clasa> clasas = user_classes.stream().map(UserClasa::getClasa).toList();
        return clasas;
    }

    @Override
    public Optional<Clasa> getWithId(Integer id, String authenticated_email) {
        return getAll(authenticated_email).stream().filter(entity -> entity.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Clasa> update(ClasaDTO ClasaDTO, Integer id, String authenticated_email) {
        Optional<Clasa> clasa = getWithId(id, authenticated_email);
        if (clasa.isPresent()){
            Clasa found = clasa.get();
            found.setNivel(ClasaDTO.getNivel());
            found.setNume(ClasaDTO.getNume());
            found.setLocalitate(ClasaDTO.getLocalitate());
            found.setJudet(ClasaDTO.getJudet());
            found.setUnitateScolara(ClasaDTO.getUnitateScolara());

            ClasaRepository.save(found);
            return Optional.of(clasa.get());
        }
        return Optional.empty();
    }

    @Override
    public void delete(Integer id, String authenticated_email) {
        Optional<Clasa> clasa = getWithId(id, authenticated_email);

        clasa.ifPresent(value -> ClasaRepository.delete(value));
    }
}
