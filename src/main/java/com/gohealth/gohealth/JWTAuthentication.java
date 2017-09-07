package com.gohealth.gohealth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Created by rameshkulkarni on 9/6/17.
 */
public class JWTAuthentication
{
    public static final String USERNAME="ghramesh2661";
    public static final String SECRET = "ThisIsASecret";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 864000000; // 10 days


    public String getJWTToken() throws Exception
    {
        String JWT = Jwts.builder()
                    .setSubject(USERNAME)
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.ES512,SECRET)
                    .compact();
        return JWT;
    }
}
