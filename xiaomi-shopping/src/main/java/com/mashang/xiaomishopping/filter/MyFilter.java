package com.mashang.xiaomishopping.filter;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.mashang.xiaomishopping.utils.JWTUtil;
import com.mashang.xiaomishopping.view.common.ResultView2;
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
          "/swagger**/**",
          "/xiaomi/doc.html",
          "/swagger-resources/**",
          "/xiaomi/webjars/**",
          "/xiaomi/v3/**",
          // 商品
          "/v2/product",
          // 热门商品
          "/v2/product/hot",
          // 商品分类
          "/v2/category",
          // 轮播图
          "/v2/carousel",
          // 注册
          "/v2/ms/user/register",
          // 登录
          "/v2/ms/user/login"

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
      servletResponse.getWriter().write(new JsonMapper().writeValueAsString(ResultView2.fail("请登录")));
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
      servletResponse.getWriter().write(new JsonMapper().writeValueAsString(ResultView2.fail("请登录")));

      return;
    }

  }
}
