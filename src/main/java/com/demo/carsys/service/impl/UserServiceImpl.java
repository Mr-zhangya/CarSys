package com.demo.carsys.service.impl;

import com.demo.carsys.entity.User;
import com.demo.carsys.mapper.UserMapper;
import com.demo.carsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Transactional
    public boolean selectUserByTelAndPassword(User user) {

         int result = userMapper.selectUserByTelAndPassword(user);
         return result > 0 ? true : false;
    }

    @Transactional
    public int register(User user) {
        return userMapper.register(user);
    }

    @Transactional
    public User selectUserByTel(String tel) {
        return userMapper.selectUserByTel(tel);
    }
}
