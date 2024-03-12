package com.springboottest.springboot01.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class MyFilter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    System.out.println("MyFilter.doFilter()");

    // 放行
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
