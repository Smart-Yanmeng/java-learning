package com.example.student.feign;

import com.test.vo.ClazzVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("clazz")
public interface ClazzFeign {
    @PostMapping("/clazz1/getClazzName")
    List<String> getClazz(@RequestBody ClazzVo clazzVo);
}
