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
import java.util.Optional;

//@ContextConfiguration(locations = "classpath:spring.xml")
@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringDataJpaTest {

    @Resource
    private StudentRepository repository;

//    @Test
//    public void testR() {
//
//        Optional<StudentPO> byId = repository.findById(2L);
//
//        System.out.println(byId.get());
//    }

    @Test
    public void testW() {
        List<StudentPO> students = repository.findAll(PageRequest.of(0, 2)).getContent();

        System.out.println(students);
    }
}
