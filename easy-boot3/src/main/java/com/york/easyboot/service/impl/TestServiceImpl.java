package com.york.easyboot.service.impl;

import com.york.easyboot.service.ITestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ITestService {
    @Override
    public void GetPhoto() {
        System.out.println("GetPhoto");
    }
}
