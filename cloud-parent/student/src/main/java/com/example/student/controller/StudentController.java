package com.example.student.controller;

import com.example.student.feign.ClazzFeign;
import com.test.vo.ClazzVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/stu1")
public class StudentController {
    @Resource
    private ClazzFeign clazzFeign;

    @GetMapping("/selectStu")
    public List<String> selectStuList() {

        ClazzVo clazzVo = new ClazzVo();

        clazzVo.setClazzNo("101");
        clazzVo.setId("1");
        List<String> clazz = clazzFeign.getClazz(clazzVo);

        System.out.println("clazz 服务的返回结果: " + clazz);


        return Arrays.asList("张三", "李四");
    }
}
