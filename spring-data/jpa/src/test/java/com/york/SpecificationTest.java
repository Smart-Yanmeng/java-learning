package com.york;

import com.york.config.SpringDataJPAConfig;
import com.york.pojo.StudentPO;
import com.york.repositories.StudentSpecificationRepository;
import jakarta.annotation.Resource;
import jakarta.persistence.criteria.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(classes = SpringDataJPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpecificationTest {

    @Resource
    private StudentSpecificationRepository studentSpecificationRepository;

    @Test
    public void test() {

        List<StudentPO> students = studentSpecificationRepository.findAll((Specification<StudentPO>) (root, query, criteriaBuilder) -> {

            Path<Long> studentId = root.get("studentId");
            Path<String> studentName = root.get("studentName");
            Path<Integer> studentNumber = root.get("studentNumber");

            Predicate pred01 = criteriaBuilder.equal(studentName, "York");
            Predicate pred02 = criteriaBuilder.greaterThanOrEqualTo(studentId, 1L);

            Predicate finalPred = criteriaBuilder.and(pred01, pred02);

            Order desc = criteriaBuilder.desc(studentId);

            return query.where(finalPred).orderBy(desc).getRestriction();
        });

        System.out.println(students);
    }
}
