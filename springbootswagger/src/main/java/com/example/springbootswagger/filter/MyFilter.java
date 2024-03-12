package com.example.springbootswagger.filter;

import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.LogRecord;

@WebFilter("/*")
public class MyFilter implements Filter {

  // 路径匹配工具
  private static AntPathMatcher antPathMatcher = new AntPathMatcher();

  // 过滤器路径的放行
  private static String urls[] = {
          "/user/login",
          "/swagger-ui/index.html",
          "/swagger-ui/springfox.css",
          "/swagger-ui/swagger-ui.css",
          "/swagger-ui/swagger-ui-bundle.js",
          "/swagger-ui/springfox.js",
          "/swagger-ui/swagger-ui-standalone-preset.js",
          "/swagger-ui/favicon-32x32.png",
          "/swagger-resources/configuration/ui",
          "/swagger-resources/configuration/security",
          "/swagger-resources",
          "/v3/api-docs",
          "/login/**"

  };

  public static void main(String[] args) {
    boolean sign = Arrays.stream(urls).anyMatch(urlPath -> antPathMatcher.match(urlPath, "/login/userlogin"));

    System.out.println(sign);
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
    String path = servletRequest1.getServletPath();
    System.out.println(servletRequest1.getServletPath());

    boolean sign = Arrays.stream(urls).anyMatch(s -> s.contains(path));
    if (sign) {
      filterChain.doFilter(servletRequest, servletResponse);
      return;
    }

    // 判断用户是否登录
    System.out.println("判断用户是否登录");
    filterChain.doFilter(servletRequest, servletResponse);

    // 如果没有登录
    // servletResponse.getWriter().write("请登录");
    // return;


  }
}
