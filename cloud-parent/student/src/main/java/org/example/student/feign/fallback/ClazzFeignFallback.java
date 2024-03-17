package org.example.student.feign.fallback;

import org.example.student.feign.ClazzFeign;
import org.example.vo.ClazzVo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ClazzFeignFallback implements ClazzFeign {
    @Override
    public List<String> getClazz(ClazzVo clazzVo) {
        return Collections.emptyList();
    }
}
