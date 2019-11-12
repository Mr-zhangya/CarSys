package com.demo.carsys.service;

import com.demo.carsys.entity.User;

public interface UserService {
    boolean selectUserByTelAndPassword(User user);

    int register(User user);

    User selectUserByTel(String tel);
}
