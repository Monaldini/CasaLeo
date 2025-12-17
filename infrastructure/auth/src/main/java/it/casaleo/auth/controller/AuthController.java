package it.casaleo.auth.controller;

import it.casaleo.auth.dto.UserDto;
import it.casaleo.auth.service.AuthService;
import it.casaleo.auth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private JwtUtil jtw;
    private AuthService authService;
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(AuthService authService, JwtUtil jtw, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.jtw = jtw;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto dto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.username(),dto.password()));
        String token = jtw.generateToken(authentication.toString());
        return ResponseEntity.ok(token);
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody String username){
        return new ResponseEntity<String>("Registrato!", HttpStatus.OK);
    }
}
