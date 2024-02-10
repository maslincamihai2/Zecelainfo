package org.example.zecelainfo.services;

import org.example.zecelainfo.dto.LoginDTO;
import org.example.zecelainfo.models.User;
import org.example.zecelainfo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.zecelainfo.dto.RegistrationDTO;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(RegistrationDTO registrationDTO) {
        User user = new User();
        user.setEmail(registrationDTO.getEmail());
        user.setParola(registrationDTO.getParola());
        user.setParola(passwordEncoder.encode(registrationDTO.getParola()));
        user.setNume(registrationDTO.getNume());
        user.setPrenume(registrationDTO.getPrenume());
        user.setRol(User.Role.valueOf(registrationDTO.getRol().toUpperCase()));
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> loginUser(LoginDTO loginDTO) {
        return userRepository.findByEmailAndParola(loginDTO.getEmail(), loginDTO.getPassword());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }



}
