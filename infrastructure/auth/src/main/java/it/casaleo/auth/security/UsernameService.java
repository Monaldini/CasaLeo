package it.casaleo.auth.security;

import it.casaleo.auth.model.User;
import it.casaleo.auth.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsernameService implements UserDetailsService {
    private AuthRepository repository;

    @Autowired
    public UsernameService(AuthRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)  throws UsernameNotFoundException{
            User user = repository.findByUsername(username).
                    orElseThrow(() -> new UsernameNotFoundException("Utente non trovato!"));

            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername())
                    .password(user.getPassword())
                    .authorities("ROLE_" + user.getRuolo().name())
                    .disabled(!user.isEnabled())
                    .build();
    }
}
