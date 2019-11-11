package com.demo.carsys.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String tel;

    private String password;

    private String email;

    private String invitation;
}