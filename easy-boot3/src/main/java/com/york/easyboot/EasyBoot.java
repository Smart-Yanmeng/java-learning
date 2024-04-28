package com.york.easyboot;

import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.york.easyboot.service.impl.AOPTestServiceImpl;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAspectJAutoProxy
@Import(JsonFactoryBuilder.class)
public class EasyBoot {

    @Resource
    private AOPTestServiceImpl aopTestService;

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(EasyBoot.class, args);

//        String[] BeanDefinitions = ioc.getBeanDefinitionNames();
//        for (String name : BeanDefinitions) {
//            System.out.println(name);
//        }

        String[] beanNamesForType = ioc.getBeanNamesForType(JsonFactoryBuilder.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
    }

    @PostConstruct
    public void executeAOPTest() {
        aopTestService.TestAOP();
    }

    @Test
    public void test() {
        System.out.println("test");
    }
}
