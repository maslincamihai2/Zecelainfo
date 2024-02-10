package org.example.zecelainfo.controllers;

import org.example.zecelainfo.dto.SolutieDTO;
import org.example.zecelainfo.dto.RegistrationDTO;
import org.example.zecelainfo.models.Solutie;
import org.example.zecelainfo.models.User;
import org.example.zecelainfo.security.JwtTokenUtil;
import org.example.zecelainfo.services.interfaces.SolutieService;
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
@RequestMapping("/api/solutie")
public class SolutieController {

    @Autowired
    private SolutieService Solutie_service;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping()
    public ResponseEntity<?> createSolutie(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody SolutieDTO SolutieDto){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.elev, User.Role.profesor, User.Role.admin)));

        if (validated_email.isPresent()){
            Optional<Solutie> Solutie_created = Solutie_service.create(SolutieDto, validated_email.get());
            return ResponseEntity.ok(Solutie_created);
        }
        return ResponseEntity.ok("error");
    }

    @GetMapping()
    public ResponseEntity<?> listSolutii(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin, User.Role.elev)));

        if (validated_email.isPresent()){
            List<Solutie> solutii = Solutie_service.getAll(validated_email.get());
            return ResponseEntity.ok(solutii);
        }
        return ResponseEntity.ok("error");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSolutie(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable Integer id){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin, User.Role.elev)));

        if (validated_email.isPresent()){
            Optional<Solutie> Solutie = Solutie_service.getWithId(id, validated_email.get());
            return ResponseEntity.ok(Solutie);
        }
        return ResponseEntity.ok("error");
    }
}
