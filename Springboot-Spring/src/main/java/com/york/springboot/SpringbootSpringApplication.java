package com.york.springboot;

import component.TestComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootSpringApplication.class, args);

        TestComponent testComponent = context.getBean("testComponent", TestComponent.class);
        testComponent.Test();
    }

}
