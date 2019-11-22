package com.demo.carsys.mapper;

import com.demo.carsys.entity.Order;
import com.demo.carsys.entity.UserOrder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderMapper {
    int ordersubmit(Order order);

    List<UserOrder> allByUid(Integer uid);

    Integer selectCountByUid(Integer uid);

    List<UserOrder> page(Map<String, Object> conditionTemp);

    Integer pageCount(Map<String, Object> conditionTemp);

    int deleteById(Integer id);
}
