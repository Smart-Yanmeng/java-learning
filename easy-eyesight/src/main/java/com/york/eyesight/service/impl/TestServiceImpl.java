package com.york.eyesight.service.impl;

import com.york.eyesight.service.ITestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ITestService {
    @Override
    public void GetPhoto() {
        System.out.println("GetPhoto");
    }
}
