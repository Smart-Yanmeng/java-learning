package com.york.websocket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.york.websocket.pojo")
@SpringBootApplication
public class TestWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestWebsocketApplication.class, args);
    }

}
