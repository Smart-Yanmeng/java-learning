package org.example.student.feign.fallback;

import feign.hystrix.FallbackFactory;
import org.example.student.feign.ClazzFeign;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ClazzFeignFallbackFactory implements FallbackFactory<ClazzFeign> {

    @Override
    public ClazzFeign create(Throwable throwable) {
        return clazzVo -> {
            throwable.printStackTrace();
            return Collections.emptyList();
        };
    }
}
