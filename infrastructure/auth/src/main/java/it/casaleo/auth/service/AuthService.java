package it.casaleo.auth.service;

import it.casaleo.auth.dto.UserDto;
import it.casaleo.auth.dto.UserMapper;
import it.casaleo.auth.model.User;
import it.casaleo.auth.repository.AuthRepository;
import it.casaleo.auth.security.SecurityConfig;
import it.casaleo.auth.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private AuthRepository authRepository;
    private UserMapper mapper;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwt;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(AuthRepository authRepository, UserMapper mapper,
                       AuthenticationManager authenticationManager,
                       JwtUtil jwt, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.mapper = mapper;
        this.authenticationManager = authenticationManager;
        this.jwt = jwt;
        this.passwordEncoder = passwordEncoder;
    }
    public UserDto registrazione(UserDto dto){
        User user = mapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));
        authRepository.save(user);
        return dto;
    }
    public String accesso (String username, String password){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,password));
        return  jwt.generateToken(authentication.getName());
    }
}
