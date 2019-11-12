package com.demo.carsys.mapper;

import com.demo.carsys.entity.Order;
import com.demo.carsys.entity.UserOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int ordersubmit(Order order);

    List<UserOrder> allByUid(Integer uid);
}
