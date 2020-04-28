package com.jianer.springbootjwt.component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.HashMap;

/**
 * @author 杨兴健
 * @Date 2020/4/26 20:07
 */
@Component
public class JwtUtil {

    private String secret = "jianer";


    public String createToken(String username) {
        HashMap<String, Object> header = new HashMap<>();
        header.put("alg","HS256");
        header.put("tye","JWT");

        Algorithm hmac256 = Algorithm.HMAC256(secret);

        Date newDate = new Date();
        Date expDate = new Date(newDate.getTime() + 60 * 1000);

        String token = JWT.create()
                .withHeader(header)
                .withIssuer("SERVICE")
                .withSubject("这是一个测试token")
                .withAudience(username)
                .withIssuedAt(newDate)
                .withExpiresAt(expDate)
                .sign(hmac256);
        return token;
    }

    public void verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("SERVICE").build();
        DecodedJWT verify = verifier.verify(token);
    }


}
