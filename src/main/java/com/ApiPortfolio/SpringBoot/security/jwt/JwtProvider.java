
package com.ApiPortfolio.SpringBoot.security.jwt;

import com.ApiPortfolio.SpringBoot.security.dto.JwtDto;
import com.ApiPortfolio.SpringBoot.security.entity.UsuarioPrincipal;
import static com.nimbusds.jose.JOSEObjectType.JWT;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.text.ParseException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${jwt.secret}")
    private String secret;
    
    @Value("${jwt.expiration}")
    private int expiration;
    
    public String generateToken(Authentication auth){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) auth.getPrincipal();
        //Hacemos setSubject al nombre de usuario
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setSubject(usuarioPrincipal.getUsername())
                .setExpiration(new Date(new Date().getTime()+expiration*1000))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }
    public String getNombreUsuarioFromToken(String token){
        //Recuperamos el nombre de usuario del token
        return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateToken(String token){        
        try{
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token);
            return true;
        }
        catch(MalformedJwtException e){
            logger.error("Token mal formado.");
        }
        catch(UnsupportedJwtException e){
            logger.error("Token no soportado.");
        }
        catch(ExpiredJwtException e){
            logger.error("Token expirado.");
        }
        catch(IllegalArgumentException e){
            logger.error("Token vacío.");
        }
        catch(SignatureException e){
            logger.error("Fail en la firma.");
        }        
        return false;
    }
    
    public String refreshToken(JwtDto jwtDto) throws ParseException{
        try{
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(jwtDto.getToken());
        } 
        catch(ExpiredJwtException e){
            JWT jwt = JWTParser.parse(jwtDto.getToken());
            JWTClaimsSet claims = jwt.getJWTClaimsSet();
            String nombreUsuario = claims.getSubject();
            return Jwts.builder()
                .setIssuedAt(new Date())
                .setSubject(nombreUsuario)
                .setExpiration(new Date(new Date().getTime()+expiration*1000))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
        }
        return null;        
    }
}
