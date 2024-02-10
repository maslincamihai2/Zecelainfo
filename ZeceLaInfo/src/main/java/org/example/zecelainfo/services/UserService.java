package org.example.zecelainfo.services;

import org.example.zecelainfo.dto.LoginDTO;
import org.example.zecelainfo.dto.RegistrationDTO;
import org.example.zecelainfo.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
    User registerUser(RegistrationDTO registrationDTO);
    Optional<User> loginUser(LoginDTO loginDTO);
}
