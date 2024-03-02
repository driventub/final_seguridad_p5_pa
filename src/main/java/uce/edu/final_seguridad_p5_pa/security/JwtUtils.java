package uce.edu.final_seguridad_p5_pa.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

    public String buildTokenJwt(String nombre, String jwtSemilla, Integer jwtExpiration ) {
        return Jwts.builder().setSubject(nombre).setSubject("Hola Mundo").setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS512, jwtSemilla).compact();
    }
}
