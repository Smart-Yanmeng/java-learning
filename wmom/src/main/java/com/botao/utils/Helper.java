package com.botao.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Map;
import java.util.UUID;

public class Helper {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static void responseJSON(HttpServletResponse resp , Map<Object, Object> map) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().print(new ObjectMapper().writeValueAsString(map));
    }
    public static String toJSONString(Map<Object, Object> map) throws IOException {
        return new ObjectMapper().writeValueAsString(map);
    }
    public static Date getSqlDate() {
        return new Date(new java.util.Date().getTime());
    }

    public static String toMd5str(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(str.getBytes(StandardCharsets.UTF_8));
        byte[] s =m.digest();
        StringBuilder result= new StringBuilder();
        for (byte b : s) {
            result.append(Integer.toHexString((0x000000ff & b) | 0xffffff00).substring(6));
        }
        return result.toString();
    }
}
