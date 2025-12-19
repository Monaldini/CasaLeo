package it.casaleo.auth.model;

import it.casaleo.auth.security.util.Ruolo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    @Column(unique = true)
    private String username;
    @NotNull
    @NotBlank
    @Size(min = 8)
    private String password;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Ruolo ruolo;
    private boolean enabled=true;
    @Column (name = "created_at")
    private LocalDate createdAt;

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
}
