package com.clinicasb.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class Token {

    private static final String SECRET_KEY = "m@tr1cul4"; // Cambia esto a una clave segura y secreta
    private static final long EXPIRATION_TIME = 86400000; // 24 horas en milisegundos

    public static String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public static String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }
    
    public static void main(String[] args) {
        String token=generateToken("kike");
        String usuario=getUsernameFromToken(token);
        System.out.println(token);
        System.out.println(usuario);
    }
}
