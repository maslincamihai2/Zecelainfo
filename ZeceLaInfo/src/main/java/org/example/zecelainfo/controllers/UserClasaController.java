package org.example.zecelainfo.controllers;

import org.example.zecelainfo.dto.ClasaDTO;
import org.example.zecelainfo.dto.UserClasaDTO;
import org.example.zecelainfo.dto.RegistrationDTO;
import org.example.zecelainfo.models.Clasa;
import org.example.zecelainfo.models.UserClasa;
import org.example.zecelainfo.models.User;
import org.example.zecelainfo.security.JwtTokenUtil;
import org.example.zecelainfo.services.interfaces.UserClasaService;
import org.example.zecelainfo.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-clasa")
public class UserClasaController {

    @Autowired
    private UserClasaService UserClasa_service;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping()
    public ResponseEntity<?> createUserClasa(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody UserClasaDTO UserClasaDto){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin)));

        if (validated_email.isPresent()){
            Optional<UserClasa> UserClasa_created = UserClasa_service.create(UserClasaDto, validated_email.get());
            return ResponseEntity.ok(UserClasa_created);
        }
        return ResponseEntity.ok("error");
    }

    @GetMapping()
    public ResponseEntity<?> getUserClasses(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin, User.Role.elev)));

        if (validated_email.isPresent()){
            List<UserClasa> UserClasa = UserClasa_service.getUserClasses(validated_email.get());
            return ResponseEntity.ok(UserClasa);
        }
        return ResponseEntity.ok("error");
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteUserClasa(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody UserClasaDTO UserClasaDto){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin)));

        if (validated_email.isPresent()){
            UserClasa_service.delete(UserClasaDto, validated_email.get());
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.ok("error");
    }
}
