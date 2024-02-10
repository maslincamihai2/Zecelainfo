package org.example.zecelainfo.controllers;

import org.example.zecelainfo.dto.ClasaDTO;
import org.example.zecelainfo.dto.TemaDTO;
import org.example.zecelainfo.dto.RegistrationDTO;
import org.example.zecelainfo.models.Clasa;
import org.example.zecelainfo.models.Tema;
import org.example.zecelainfo.models.User;
import org.example.zecelainfo.security.JwtTokenUtil;
import org.example.zecelainfo.services.interfaces.TemaService;
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
@RequestMapping("/api/tema")
public class TemaController {

    @Autowired
    private TemaService Tema_service;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping()
    public ResponseEntity<?> createTema(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody TemaDTO TemaDto){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin)));

        if (validated_email.isPresent()){
            Optional<Tema> Tema_created = Tema_service.create(TemaDto, validated_email.get());
            return ResponseEntity.ok(Tema_created);
        }
        return ResponseEntity.ok("error");
    }

    @GetMapping()
    public ResponseEntity<?> listTeme(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin, User.Role.elev)));

        if (validated_email.isPresent()){
            List<Tema> teme = Tema_service.getAll(validated_email.get());
            return ResponseEntity.ok(teme);
        }
        return ResponseEntity.ok("error");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTema(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable Integer id){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin, User.Role.elev)));

        if (validated_email.isPresent()){
            Optional<Tema> Tema = Tema_service.getWithId(id, validated_email.get());
            return ResponseEntity.ok(Tema);
        }
        return ResponseEntity.ok("error");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTema(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody TemaDTO TemaDto, @PathVariable Integer id){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin)));

        if (validated_email.isPresent()){
            Optional<Tema> Tema_updated = Tema_service.update(TemaDto, id, validated_email.get());
            return ResponseEntity.ok(Tema_updated);
        }
        return ResponseEntity.ok("error");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTema(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable Integer id){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin)));

        if (validated_email.isPresent()){
            Tema_service.delete(id, validated_email.get());
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.ok("error");
    }
}
