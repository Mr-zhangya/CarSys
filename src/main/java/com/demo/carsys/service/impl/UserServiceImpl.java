package com.demo.carsys.service.impl;

import com.demo.carsys.entity.User;
import com.demo.carsys.mapper.UserMapper;
import com.demo.carsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public boolean selectUserByTelAndPassword(User user) {

         int result = userMapper.selectUserByTelAndPassword(user);
         return result > 0 ? true : false;
    }

    public int register(User user) {
        return userMapper.register(user);
    }
}
