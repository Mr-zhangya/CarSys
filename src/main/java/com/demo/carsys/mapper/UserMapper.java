package com.demo.carsys.mapper;

import com.demo.carsys.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int selectUserByTelAndPassword(User user);

    int register(User user);

    User selectUserByTel(String tel);
}
