package com.demo.carsys.service.impl;

import com.demo.carsys.entity.Order;
import com.demo.carsys.entity.UserOrder;
import com.demo.carsys.mapper.OrderMapper;
import com.demo.carsys.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Transactional
    public int ordersubmit(Order order) {
        return orderMapper.ordersubmit(order);
    }

    @Transactional
    public List<UserOrder> allByUid(Integer uid) {
        return orderMapper.allByUid(uid);
    }
}
