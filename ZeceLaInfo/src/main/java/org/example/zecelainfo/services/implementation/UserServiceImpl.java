package org.example.zecelainfo.services.implementation;

import org.example.zecelainfo.dto.LoginDTO;
import org.example.zecelainfo.models.User;
import org.example.zecelainfo.repositories.UserRepository;
import org.example.zecelainfo.security.JwtTokenUtil;
import org.example.zecelainfo.services.interfaces.UserService;
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
        user.setRol(User.Role.valueOf(registrationDTO.getRol()));
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<String> loginUser(LoginDTO loginDTO) {
        Optional<User> user = userRepository.findByEmail(loginDTO.getEmail());

        if (user.isPresent() && passwordEncoder.matches(loginDTO.getParola(), user.get().getParola())){
            JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
            final String token = jwtTokenUtil.generateToken(user.get());
            return Optional.of(token);
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
