package com.york.testthymeleaf.entity;

import lombok.Data;

@Data
public class UserEntity {

    private Long userId;

    private String username;

    private String password;
}
