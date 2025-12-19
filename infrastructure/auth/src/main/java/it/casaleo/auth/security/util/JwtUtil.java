package it.casaleo.auth.security.util;

import io.jsonwebtoken.*;
import it.casaleo.auth.exception.JwtTokenMalformedException;
import it.casaleo.auth.exception.JwtTokenMissingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class JwtUtil {
    private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.token.validity}")
    private long tokenValidity;

    public Optional<Claims> getClaims(final String token) {
        try {
            Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
            return Optional.of(body);
        } catch (Exception e) {
            log.error("Errore parsing JWT", e);
        }
        return Optional.empty();
    }

    public String generateToken(String subject) {
        Claims claims = Jwts.claims().setSubject(subject);
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + tokenValidity;
        Date exp = new Date(expMillis);
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowMillis)).setExpiration(exp)
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public void validateToken(final String token) throws JwtTokenMalformedException, JwtTokenMissingException {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
        } catch (SignatureException ex) {
            throw new JwtTokenMalformedException("Firma JWT non valida");
        } catch (MalformedJwtException ex) {
            throw new JwtTokenMalformedException("Token JWT non valido");
        } catch (ExpiredJwtException ex) {
            throw new JwtTokenMalformedException("Token JWT scaduto");
        } catch (UnsupportedJwtException ex) {
            throw new JwtTokenMalformedException("Token JWT non supportato");
        } catch (IllegalArgumentException ex) {
            throw new JwtTokenMissingException("La stringa delle dichiarazioni JWT è vuota.");
        }
    }
}
