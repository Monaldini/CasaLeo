package it.casaleo.auth.controller;

import it.casaleo.auth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JwtUtil jtw;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String username){
        String token = jtw.generateToken(username);
        return new ResponseEntity<String>(token,HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody String username){
        return new ResponseEntity<String>("Registrato!", HttpStatus.OK);
    }
}
