package it.casaleo.auth.model;

import it.casaleo.auth.util.Ruolo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
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
}
