package org.example.student.feign;

import org.example.student.feign.fallback.ClazzFeignFallback;
import org.example.vo.ClazzVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "clazz", fallback = ClazzFeignFallback.class)
public interface ClazzFeign {

    @PostMapping("/clazz/getClazzName")
    List<String> getClazz(@RequestBody ClazzVo clazzVo);
}
