package com.demo.carsys.service;


import com.demo.carsys.entity.User;

public interface RegisterService {
    int verifyTel(String tel);

    int validate(User user);
}
