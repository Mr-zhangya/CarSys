package com.demo.carsys.service.impl;

import com.demo.carsys.entity.Order;
import com.demo.carsys.entity.Page;
import com.demo.carsys.entity.UserOrder;
import com.demo.carsys.mapper.OrderMapper;
import com.demo.carsys.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

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

    public Integer selectCountByUid(Integer uid) {
        return orderMapper.selectCountByUid(uid);
    }

    public Page page(Map<String, String> conditions) {
        int pageNum = 1;
        int pageSize = 5;
        if(conditions.containsKey("pageNum")) {
            pageNum = Integer.parseInt(conditions.get("pageNum"));
            pageSize = Integer.parseInt(conditions.get("pageSize"));
        }
        Page page = new Page(pageNum,pageSize);
        int uid = Integer.parseInt(conditions.get("uid"));
        Map<String,Object> conditionTemp = new HashMap<String, Object>();
        conditionTemp.putAll(conditions);

        conditionTemp.put("uid",uid);
        conditionTemp.put("startIndex",page.getStartIndex());
        conditionTemp.put("pageSize",pageSize);

        logger.info("++++++++++++++OrderImpl 层的数据+++++++++++++++");
        logger.info(conditionTemp);
        logger.info("+++++++++++++++++++++++++++++++++++++++++++++++");


        page.setResult(orderMapper.page(conditionTemp));
        page.setTotal(orderMapper.pageCount(conditionTemp));

        logger.info("++++++++++++++  total  的数据+++++++++++++++");
        logger.info(page.getTotal());
        logger.info("+++++++++++++++++++++++++++++++++++++++++++++++");


        return page;
    }

    public int deleteById(Integer id) {
        return orderMapper.deleteById(id);
    }
}
