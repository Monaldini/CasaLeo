package it.casaleo.auth.util;

import io.jsonwebtoken.*;
import it.casaleo.auth.exception.JwtTokenMalformedException;
import it.casaleo.auth.exception.JwtTokenMissingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.token.validity}")
    private long tokenValidity;

    public Claims getClaims(final String token) {
        try {
            Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
            return body;
        } catch (Exception e) {
            System.out.println(e.getMessage() + " => " + e);
        }
        return null;
    }

    public String generateToken(String id) {
        Claims claims = Jwts.claims().setSubject(id);
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
