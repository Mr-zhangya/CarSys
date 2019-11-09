package com.demo.carsys.service;

import com.demo.carsys.entity.User;

public interface UserService {
    boolean selectUserByTelAndPassword(User user);
}
