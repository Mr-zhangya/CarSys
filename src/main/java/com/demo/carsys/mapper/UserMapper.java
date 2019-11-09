package com.demo.carsys.mapper;

import com.demo.carsys.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int selectUserByTelAndPassword(User user);
}
