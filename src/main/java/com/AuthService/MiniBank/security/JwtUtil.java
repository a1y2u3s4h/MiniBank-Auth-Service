package com.AuthService.MiniBank.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {

    private static final String SECRET =
            "mysecretkeymysecretkeymysecretkeymysecretkey";

    private static final SecretKey KEY =
            Keys.hmacShaKeyFor(SECRET.getBytes());

     
    
    public String generateToken(String email, String role) {

        return Jwts.builder()
                .subject(email)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                + 1000 * 60 * 60))
                .signWith(KEY)
                .compact();
    }
    
    
    public String extractEmail(String token) {

        return Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validateToken(String token) {

        try {

            Jwts.parser()
                    .verifyWith(KEY)
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}