package it.casaleo.auth.dto;

import it.casaleo.auth.util.Ruolo;

import java.time.LocalDate;
import java.util.UUID;

public record UserDto(UUID id, String username, String password, String email,
                      Ruolo ruolo, boolean enabled, LocalDate createdAt) {
}
