package com.demo.carsys.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface RegisterMapper {
    int verifyTel(String tel);

    int selectUserByEmail(String email);
}
