package com.springboottest.springboot01.config;

import com.springboottest.springboot01.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

  String[] interceptorPath = {
          "/**"
  };

  String[] excludePath = {};

  @Override
  public void addInterceptors(InterceptorRegistry registry) {

    registry.addInterceptor(new MyInterceptor())
            .addPathPatterns(interceptorPath)
            .excludePathPatterns(excludePath);

  }
}
