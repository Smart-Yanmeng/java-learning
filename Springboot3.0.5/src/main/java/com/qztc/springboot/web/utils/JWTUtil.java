package com.qztc.springboot.web.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtil {
    private static final String SIGN = "SHaRwaSS675%^$%&YORK44$";

    /**
     * 生成 Token
     *
     * @param map
     * @return
     */
    public static String getToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);

        JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);

        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SIGN));

        return token;
    }

    /**
     * 验证 Token
     *
     * @param token
     */
    public static DecodedJWT verify(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);

        return verify;
    }
}
