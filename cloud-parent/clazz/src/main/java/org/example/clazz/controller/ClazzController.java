package org.example.clazz.controller;

import org.example.vo.ClazzVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clazz")
public class ClazzController {

    @PostMapping("/getClazzName")
    public List<String> getClazz(@RequestBody ClazzVo clazzVo) {
        System.out.println("ClazzController.ClazzVo: " + clazzVo);

        return Arrays.asList("高一一班", "高一二班", "高一三班");
    }
}
