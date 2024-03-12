package com.mashang.xiaomishopping.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.*;

public class JWTUtil {

  private static final String SECRET = "fdnsiaofjiosgjiso";

  /**
   * @param paramMap   要存储的参数
   * @param expireDate 过期时间
   * @return
   */
  public static String getToken(Map<String, String> paramMap, Date expireDate) {

    JWTCreator.Builder builder = JWT.create().withHeader(new HashMap<>());

    // 封装参数
    Set<String> keySet = paramMap.keySet();
    Iterator<String> iterator = keySet.iterator();

    while (iterator.hasNext()) {
      String key = iterator.next();
      String value = paramMap.get(key);
      builder.withClaim(key, value);
    }

    // 封装过期的日期
    if (expireDate != null) {
      builder.withExpiresAt(expireDate);
    }

    return builder.sign(Algorithm.HMAC256(SECRET));
  }

  /**
   * 根据 key 获取 token 中的值
   *
   * @param key
   * @param token
   * @return
   * @throws Exception
   */
  public static String getClaim(String key, String token) throws Exception {
    DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
    return decodedJWT.getClaim(key).asString();
  }

}
