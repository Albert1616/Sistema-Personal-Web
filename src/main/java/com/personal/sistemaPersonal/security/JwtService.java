package com.personal.sistemaPersonal.security;

import com.personal.sistemaPersonal.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.xml.crypto.Data;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DecimalStyle;
import java.util.Date;

@Service
public class JwtService {

    @Value("${security.jwt.expiracao}")
    private String expiracao;

    @Value("${security.jwt.chave-assinatura}")
    private String chaveAssinatura;

    public String createToken(User user){
        Date data = converter(expiracao);
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(chaveAssinatura));

        return Jwts.builder()
                .subject(user.getLogin())
                .expiration(data)
                .signWith(secretKey)
                .compact();
    }

    public Claims getClaims(String token) throws ExpiredJwtException {
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(chaveAssinatura));

        return Jwts
                .parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean tokenValido( String token ){
        try{
            Claims claims = (Claims) getClaims(token);
            Date dataExpiracao = claims.getExpiration();
            LocalDateTime data =
                    dataExpiracao.toInstant()
                            .atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(data);
        }catch (Exception e){
            return false;
        }
    }


    public String obterLoginUsuario(String token) throws ExpiredJwtException{
        return (String) (getClaims(token)).getSubject();
    }

    public Date converter(String expiration){

        long expString = Long.valueOf(expiration);
        LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString);
        Instant instant = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
        Date data = Date.from(instant);
        return data;
    }
}
