package com.york.invokepython;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@SpringBootTest
class InvokePythonApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        try {
            String[] cmd = {
                    "python",
                    "src/main/java/com/york/invokepython/HelloWorld.py"
            };

            ProcessBuilder pb = new ProcessBuilder(cmd);

            Process process = pb.start();

            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
