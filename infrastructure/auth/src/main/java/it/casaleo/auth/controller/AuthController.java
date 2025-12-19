package it.casaleo.auth.controller;

import it.casaleo.auth.dto.UserDto;
import it.casaleo.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password){
        authService.accesso(username, password);
        return ResponseEntity.ok("Autenticato!");
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto user){
        authService.registrazione(user);
        return new ResponseEntity<String>("Registrato!", HttpStatus.OK);
    }
}
