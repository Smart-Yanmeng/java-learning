package com.york.easyboot;

import com.york.easyboot.service.impl.AOPTestServiceImpl;
import com.york.easyboot.service.impl.TestServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class EasyBoot {

    @Autowired
    private AOPTestServiceImpl aopTestService;

    public static void main(String[] args) {
        SpringApplication.run(EasyBoot.class, args);
    }

    @PostConstruct
    public void executeAOPTest() {
        aopTestService.TestAOP();
    }
}
