package com.demo.carsys.service;


import com.demo.carsys.entity.Order;
import com.demo.carsys.entity.UserOrder;

import java.util.List;

public interface OrderService {

    int ordersubmit(Order order);

    List<UserOrder> allByUid(Integer uid);
}
