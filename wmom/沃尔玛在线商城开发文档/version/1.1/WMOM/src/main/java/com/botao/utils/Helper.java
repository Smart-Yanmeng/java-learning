package com.botao.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class Helper {
    public static void responseJSON(HttpServletResponse resp , Map<Object, Object> map) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().print(new ObjectMapper().writeValueAsString(map));
    }
    public static String toJSONString(Map<Object, Object> map) throws IOException {
        return new ObjectMapper().writeValueAsString(map);
    }
}
