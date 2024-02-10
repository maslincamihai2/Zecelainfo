package org.example.zecelainfo.controllers;

import org.example.zecelainfo.dto.ClasaDTO;
import org.example.zecelainfo.dto.ProblemaDTO;
import org.example.zecelainfo.dto.RegistrationDTO;
import org.example.zecelainfo.models.Clasa;
import org.example.zecelainfo.models.Problema;
import org.example.zecelainfo.models.User;
import org.example.zecelainfo.security.JwtTokenUtil;
import org.example.zecelainfo.services.interfaces.ClasaService;
import org.example.zecelainfo.services.interfaces.ProblemaService;
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
@RequestMapping("/api/problema")
public class ProblemaController {

    @Autowired
    private ProblemaService Problema_service;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping()
    public ResponseEntity<?> createProblema(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody ProblemaDTO ProblemaDto){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.admin)));

        if (validated_email.isPresent()){
            Optional<Problema> Problema_created = Problema_service.create(ProblemaDto, validated_email.get());
            return ResponseEntity.ok(Problema_created);
        }
        return ResponseEntity.ok("error");
    }

    @GetMapping()
    public ResponseEntity<?> listProbleme(){

        List<Problema> probleme = Problema_service.getAll();
        return ResponseEntity.ok(probleme);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProblem(@PathVariable Integer id){

        Optional<Problema> problema = Problema_service.getWithId(id);
        return ResponseEntity.ok(problema);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClass(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody ProblemaDTO ProblemaDto, @PathVariable Integer id){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.admin)));

        if (validated_email.isPresent()){
            Optional<Problema> Problema_updated = Problema_service.update(ProblemaDto, id, validated_email.get());
            return ResponseEntity.ok(Problema_updated);
        }
        return ResponseEntity.ok("error");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClass(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable Integer id){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.admin)));

        if (validated_email.isPresent()){
            Problema_service.delete(id, validated_email.get());
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.ok("error");
    }
}
