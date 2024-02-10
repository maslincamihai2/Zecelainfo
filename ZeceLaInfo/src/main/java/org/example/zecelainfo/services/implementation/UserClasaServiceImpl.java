package org.example.zecelainfo.services.implementation;

import org.example.zecelainfo.dto.UserClasaDTO;
import org.example.zecelainfo.models.*;
import org.example.zecelainfo.models.UserClasa;
import org.example.zecelainfo.repositories.ClasaRepository;
import org.example.zecelainfo.repositories.UserClasaRepository;
import org.example.zecelainfo.repositories.UserRepository;
import org.example.zecelainfo.services.interfaces.UserClasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserClasaServiceImpl implements UserClasaService {

    @Autowired
    private UserClasaRepository UserClasaRepository;

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private ClasaRepository ClasaRepository;

    @Override
    public Optional<UserClasa> create(UserClasaDTO UserClasaDTO, String authenticated_email) {
        UserClasa UserClasa = new UserClasa();

        Optional<User> User = UserRepository.findById(UserClasaDTO.getIdUser());
        Optional<Clasa> Clasa = ClasaRepository.findById(UserClasaDTO.getIdClasa());

        if(User.isEmpty() || Clasa.isEmpty()){
            return Optional.empty();
        }

        UserClasa.setClasa(Clasa.get());
        UserClasa.setUser(User.get());

        UserClasaRepository.save(UserClasa);

        return Optional.of(UserClasa);
    }

    @Override
    public List<UserClasa> getUserClasses(String authenticated_email) {
        Optional<User> user = UserRepository.findByEmail(authenticated_email);

        return UserClasaRepository.findUserClasasByUser(user.get());
    }

    @Override
    public void delete(UserClasaDTO UserClasaDTO, String authenticated_email) {
        Optional<User> User = UserRepository.findById(UserClasaDTO.getIdUser());
        Optional<Clasa> Clasa = ClasaRepository.findById(UserClasaDTO.getIdClasa());

        if(User.isEmpty() || Clasa.isEmpty()){
            return;
        }

        UserClasaRepository.deleteUserClasaByUserAndClasa(User.get(), Clasa.get());
    }
}
