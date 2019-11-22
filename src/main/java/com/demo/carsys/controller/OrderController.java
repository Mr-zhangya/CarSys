package com.demo.carsys.controller;

import com.demo.carsys.entity.Order;
import com.demo.carsys.entity.Page;
import com.demo.carsys.entity.UserOrder;
import com.demo.carsys.service.OrderService;
import com.demo.carsys.utils.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    OrderService orderService;

    @RequestMapping("/ordersubmit")
    public String ordersubmit() {
        return "ordersubmit";
    }

    @RequestMapping("/add")
    @ResponseBody
    /*Integer getid,Integer backid,Integer cid,Double total*/
    public String add(Integer getid, Integer backid, Integer cid, Double oprice, HttpSession session) {
        session.getAttribute("userId");
        logger.info("*********************userId*****************");
        logger.info(session.getAttribute("userId"));
        logger.info(oprice);
        logger.info("********************************************");

        Order order = new Order();
        order.setBackid(backid);
        order.setCid(cid);
        order.setGetid(getid);
        order.setOprice(oprice);
        order.setUid((Integer) session.getAttribute("userId"));
        int count = orderService.ordersubmit(order);
        if (count > 0) {
            return JsonUtils.objectToJson("success");
        }
        return JsonUtils.objectToJson("fail");
    }

    @RequestMapping("/mymain")
    public String myMain() {
        return "mymain";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String all(@RequestParam Map<String,String > conditions, HttpSession session) {
        logger.info("********************userId********************");
        logger.info(session.getAttribute("userId"));
        logger.info("********************************************");

        /*Integer uid = (Integer) session.getAttribute("userId");
        List<UserOrder> userOrder = orderService.allByUid(uid);
        Integer total = orderService.selectCountByUid(uid);*/

        //String userId = (String) session.getAttribute("userId");
        conditions.put("uid",String.valueOf(session.getAttribute("userId")) );
        Page page = orderService.page(conditions);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("data",page);

        //map.put("total",total);
        logger.info("********************订单信息********************");
        logger.info(JsonUtils.objectToJson(map));
        logger.info("********************************************");

        return JsonUtils.objectToJson(map);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteById(Integer id) {
        logger.info("订单id++++++++++++++"+id);
        int count = orderService.deleteById(id);
        if (count != 0) {
            return JsonUtils.objectToJson("success");
        }
        return JsonUtils.objectToJson("fail");
    }
}
