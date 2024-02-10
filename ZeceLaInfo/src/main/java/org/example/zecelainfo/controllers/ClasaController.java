package org.example.zecelainfo.controllers;

import org.example.zecelainfo.dto.ClasaDTO;
import org.example.zecelainfo.dto.RegistrationDTO;
import org.example.zecelainfo.models.Clasa;
import org.example.zecelainfo.models.User;
import org.example.zecelainfo.security.JwtTokenUtil;
import org.example.zecelainfo.services.interfaces.ClasaService;
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
@RequestMapping("/api/clasa")
public class ClasaController {

    @Autowired
    private ClasaService Clasa_service;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping()
    public ResponseEntity<?> createClasa(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody ClasaDTO ClasaDto){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin)));

        if (validated_email.isPresent()){
            Optional<Clasa> Clasa_created = Clasa_service.create(ClasaDto, validated_email.get());
            return ResponseEntity.ok(Clasa_created);
        }
        return ResponseEntity.ok("error");
    }

    @GetMapping()
    public ResponseEntity<?> listClasses(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin, User.Role.elev)));

        if (validated_email.isPresent()){
            List<Clasa> classes = Clasa_service.getAll(validated_email.get());
            return ResponseEntity.ok(classes);
        }
        return ResponseEntity.ok("error");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClass(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable Integer id){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin, User.Role.elev)));

        if (validated_email.isPresent()){
            Optional<Clasa> clasa = Clasa_service.getWithId(id, validated_email.get());
            return ResponseEntity.ok(clasa);
        }
        return ResponseEntity.ok("error");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClass(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody ClasaDTO ClasaDto, @PathVariable Integer id){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin)));

        if (validated_email.isPresent()){
            Optional<Clasa> Clasa_updated = Clasa_service.update(ClasaDto, id, validated_email.get());
            return ResponseEntity.ok(Clasa_updated);
        }
        return ResponseEntity.ok("error");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClass(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable Integer id){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin)));

        if (validated_email.isPresent()){
            Clasa_service.delete(id, validated_email.get());
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.ok("error");
    }
}
