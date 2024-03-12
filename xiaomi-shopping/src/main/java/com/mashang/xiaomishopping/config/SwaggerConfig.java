package com.mashang.xiaomishopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Component
@EnableSwagger2 // 启用 swagger
public class SwaggerConfig {

  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.OAS_30)
            .apiInfo(apiInfo())
            .enable(true)
            .select()// 开始配置要生成哪些接口文档
            .apis(RequestHandlerSelectors.basePackage("com.mashang.xiaomishopping"))
            .paths(PathSelectors.any())
            .build()
            .groupName("学生管理系统模块");
  }

  /**
   * 基本信息
   *
   * @return
   */
  @Bean
  private ApiInfo apiInfo() {
    Contact contact = new Contact("联系人名字", "http://xxx.xxx.com/联系人访问链接", "联系人邮箱");
    return new ApiInfo("Swagger学习", // 标题
            "学习演示如何配置Swagger", // 描述
            "v1.0", // 版本
            "http://terms.service.url/组织链接", // 组织链接
            contact, // 联系人信息
            "Apach 2.0 许可", // 许可
            "许可链接", // 许可连接
            new ArrayList<>()); // 扩展
  }
}
