package com.qztc.springboot.web.domain.entity;

import lombok.Data;

@Data
public class UserEntity {
    private Long id;

    private String username;

    private String password;
}