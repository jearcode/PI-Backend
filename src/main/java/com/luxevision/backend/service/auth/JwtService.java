package com.luxevision.backend.service.auth;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    @Value("${security.jwt.expiration-in-minutes}")
    private Long EXPIRATION_IN_MINUTES;
    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String generateToken(UserDetails user, Map<String, Object> extraClaims) {

        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date( (EXPIRATION_IN_MINUTES * 60 * 1000) + issuedAt.getTime() );

        String jwt = Jwts.builder()
                .header()
                    .type("JWT")
                    .and()

                .subject(user.getUsername())
                .issuedAt(issuedAt)
                .expiration(expiration)
                .claims(extraClaims)

                .signWith(generateKey(), Jwts.SIG.HS256)
                .compact();

        return jwt;

    }

    public boolean validateToken(String jwt) {
        try {
            Jwts.parser().verifyWith(generateKey()).build()
                            .parseSignedClaims(jwt).getPayload();
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    private SecretKey generateKey () {
        byte[] key = SECRET_KEY.getBytes();
        return Keys.hmacShaKeyFor(key);
    }

    public String extractEmail(String jwt) {
        return extractAllClaims(jwt).getSubject();
    }

    public Claims extractAllClaims (String jwt) {
        return Jwts.parser().verifyWith(generateKey()).build()
                .parseSignedClaims(jwt).getPayload();
    }

}
