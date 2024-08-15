package com.york;

import com.york.repositories.StudentRepository;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = com.york.config.SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JpqlTest {

    @Resource
    private StudentRepository repository;

    @Test
    public void testJpql() {
        System.out.println(repository.findByStudentName("York"));
    }
}
