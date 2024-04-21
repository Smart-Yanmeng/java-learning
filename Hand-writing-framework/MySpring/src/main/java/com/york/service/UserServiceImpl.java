package com.york.service;

import com.spring.Autowired;
import com.spring.BeanNameAware;
import com.spring.Component;
import com.spring.InitializingBean;

@Component("userService")
public class UserServiceImpl implements BeanNameAware, InitializingBean, IUserService {

    @Autowired
    private OrderService orderService;

    private String name;

    private String beanName;

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserService init");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void test() {
        System.out.println(orderService);
        System.out.println(beanName);
        System.out.println(name);
    }
}
