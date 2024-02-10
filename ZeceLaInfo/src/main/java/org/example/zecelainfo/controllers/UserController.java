package org.example.zecelainfo.controllers;

import org.example.zecelainfo.dto.LoginDTO;
import org.example.zecelainfo.dto.RegistrationDTO;
import org.example.zecelainfo.models.User;
import org.example.zecelainfo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationDTO registrationDTO){
        User user = userService.registerUser(registrationDTO);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        Optional<User> user = userService.loginUser(loginDTO);
        return ResponseEntity.ok(user);
    }
    //public User registerUser(@RequestBody User user) {
        //return userService.saveUser(user);
            //}

    @GetMapping("/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}
