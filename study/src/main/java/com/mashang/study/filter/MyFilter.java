package com.mashang.study.filter;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.mashang.study.utils.JWTUtil;
import com.mashang.study.view.LoginResultView;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/*")
public class MyFilter implements Filter {

  // 路径匹配工具
  private static AntPathMatcher antPathMatcher = new AntPathMatcher();

  // 过滤器路径的放行
  private static String urls[] = {
          // 注册
          "/user/register",
          // 登录
          "/user/UserController"

  };

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
    String path = servletRequest1.getServletPath();

    boolean sign = Arrays.stream(urls).anyMatch(s -> s.contains(path));
    if (sign) {
      filterChain.doFilter(servletRequest, servletResponse);

      return;
    }

    // 判断用户是否登录
    String token = servletRequest1.getHeader("Authorization");

    if (StrUtil.isEmpty(token)) {
      servletResponse.setContentType("text/html;charset=utf-8");
      servletResponse.getWriter().write(new JsonMapper().writeValueAsString(LoginResultView.fail("请登录")));
      return;
    }

    try {
      String id = JWTUtil.getClaim("id", token);

      // 将这个用户 id 放到请求头上
      HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(servletRequest1);
      requestWrapper.addHeader("userId", id);
      filterChain.doFilter(requestWrapper, servletResponse);

    } catch (Exception e) {
      e.printStackTrace();
      servletResponse.setContentType("text/html;charset=utf-8");
      servletResponse.getWriter().write(new JsonMapper().writeValueAsString(LoginResultView.fail("请登录")));

      return;
    }

  }
}
