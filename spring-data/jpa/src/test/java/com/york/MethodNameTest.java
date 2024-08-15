package com.york;

import com.york.config.SpringDataJPAConfig;
import com.york.pojo.StudentPO;
import com.york.repositories.StudentRepository;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MethodNameTest {

    @Resource
    private StudentRepository repository;

    @Test
    public void test() {

        List<StudentPO> list = repository.findByStudentName("york", PageRequest.of(0, 2));

        System.out.println(list);
    }
}
