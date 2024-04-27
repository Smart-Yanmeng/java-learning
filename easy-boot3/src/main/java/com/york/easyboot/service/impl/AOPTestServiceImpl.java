package com.york.easyboot.service.impl;

import com.york.easyboot.service.IAOPTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AOPTestServiceImpl implements IAOPTestService {

    @Autowired
    private TestServiceImpl testService;

    @Override
    public void TestAOP() {
        System.out.println(testService);
    }
}
