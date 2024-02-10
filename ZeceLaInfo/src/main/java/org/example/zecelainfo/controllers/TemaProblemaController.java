package org.example.zecelainfo.controllers;

import org.example.zecelainfo.dto.ClasaDTO;
import org.example.zecelainfo.dto.TemaProblemaDTO;
import org.example.zecelainfo.dto.RegistrationDTO;
import org.example.zecelainfo.models.Clasa;
import org.example.zecelainfo.models.TemaProblema;
import org.example.zecelainfo.models.User;
import org.example.zecelainfo.security.JwtTokenUtil;
import org.example.zecelainfo.services.interfaces.TemaProblemaService;
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
@RequestMapping("/api/tema-problema")
public class TemaProblemaController {

    @Autowired
    private TemaProblemaService TemaProblema_service;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/create")
    public ResponseEntity<?> createTemaProblema(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody TemaProblemaDTO TemaProblemaDto){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin)));

        if (validated_email.isPresent()){
            Optional<TemaProblema> TemaProblema_created = TemaProblema_service.create(TemaProblemaDto, validated_email.get());
            return ResponseEntity.ok(TemaProblema_created);
        }
        return ResponseEntity.ok("error");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTemaProblemaByTema(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable Integer id){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin, User.Role.elev)));

        if (validated_email.isPresent()){
            List<TemaProblema> TemaProblema = TemaProblema_service.getWithTemaId(id, validated_email.get());
            return ResponseEntity.ok(TemaProblema);
        }
        return ResponseEntity.ok("error");
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteTemaProblema(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody TemaProblemaDTO TemaProblemaDto){
        Optional<String> validated_email = jwtTokenUtil.validateToken(
                token,
                new ArrayList<>(Arrays.asList(User.Role.profesor, User.Role.admin)));

        if (validated_email.isPresent()){
            TemaProblema_service.delete(TemaProblemaDto, validated_email.get());
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.ok("error");
    }
}
