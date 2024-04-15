package com.york.eyesight;

import com.york.eyesight.pojo.dto.RUserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EasyEyesightApplicationTests {

    @Test
    void contextLoads() {
        RUserDTO user = new RUserDTO("test", "test");

        String username = user.username();
        System.out.println(username);
    }
}
