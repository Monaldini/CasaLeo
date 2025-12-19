package it.casaleo.auth.service;


import it.casaleo.auth.dto.UserDto;
import it.casaleo.auth.dto.UserMapper;
import it.casaleo.auth.model.User;
import it.casaleo.auth.repository.AuthRepository;
import it.casaleo.auth.security.SecurityConfig;
import it.casaleo.auth.security.UsernameService;
import it.casaleo.auth.security.util.JwtUtil;
import it.casaleo.auth.security.util.Ruolo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.mockito.InjectMocks;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtUtil jwt;
    @Mock
    private Authentication authentication;
    @Mock
    private UserMapper mapper;
    @Mock
    private PasswordEncoder encoder;

    @Test
    public void testiamoAccesso(){
        String fakeUsername = "marco9615";
        String fakePassword = "cjsnkjcnfkdfn";
        String fakeToken = "jwtESEMPIO";

        when(authenticationManager.authenticate(any())).thenReturn(authentication);
        when(jwt.generateToken(any())).thenReturn(fakeToken);

        String risultatoTest = authService.accesso(fakeUsername,fakePassword);
        assertEquals(fakeToken, risultatoTest);

    }
    @Test
    public void registrazioneTest(){
        UserDto dto = new UserDto(UUID.randomUUID(),"marco9615","aaa","monaldini@mail.it", Ruolo.CLIENT,true, LocalDate.now());
        when(mapper.toEntity(dto)).thenReturn(new User());
        when(encoder.encode(any())).thenReturn("encoded");
        UserDto risultatoTest = authService.registrazione(dto);
        assertEquals(dto,risultatoTest);
    }
}
