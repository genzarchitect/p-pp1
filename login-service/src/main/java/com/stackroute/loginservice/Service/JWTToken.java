package com.stackroute.loginservice.Service;

import com.stackroute.loginservice.model.UserCredential;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class JWTToken implements TokenGeneratorService {
    @Value("${jwt.secret.key}")
    private String secretKey;
    @Override
    public Map<String, String> generateToken(UserCredential credential) {
        String token= Jwts.builder().setSubject(credential.getUseremail())
                .setIssuer("Serviceused")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
        return Map.of("token" ,token);
    }
}
