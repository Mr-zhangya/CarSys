package com.demo.carsys.service;


import com.demo.carsys.entity.Order;
import com.demo.carsys.entity.Page;
import com.demo.carsys.entity.UserOrder;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.List;
import java.util.Map;

public interface OrderService {

    int ordersubmit(Order order);

    List<UserOrder> allByUid(Integer uid);

    Integer selectCountByUid(Integer uid);

    Page page(Map<String, String> conditions);

    int deleteById(Integer id);
}
