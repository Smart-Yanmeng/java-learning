package org.example.student.controller;

import org.example.student.feign.ClazzFeign;
import org.example.vo.ClazzVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Resource
    private ClazzFeign clazzFeign;

    @GetMapping("/selectStu")
    public List<String> selectStuList() {

        ClazzVo clazzVo = new ClazzVo();
        clazzVo.setId("1");
        clazzVo.setClazzNo("001");
        List<String> clazz = clazzFeign.getClazz(clazzVo);

        if (clazz == null) {
            System.out.println("服务调用失败");

            return Collections.singletonList("Fail");
        }

        System.out.println("clazz服务返回：" + clazz);

        return Arrays.asList("张三", "李四", "王五");
    }
}
