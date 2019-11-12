package com.demo.carsys.controller;
import com.demo.carsys.entity.City;
import com.demo.carsys.service.ShortRentService;
import com.demo.carsys.utils.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/rent")
@Controller
public class ShortRentController {
    private static final Logger logger = LogManager.getLogger(UserController.class);


    @Autowired
    ShortRentService shortRentService;

    @RequestMapping("/shortRent")
    public String rent() {
        return "shortrent";
    }


    @RequestMapping(value = "/select",method = RequestMethod.POST)
    @ResponseBody
    public String selectCity(Integer pid) {
        List<City> cityList = shortRentService.selectCity(pid);
        logger.info(cityList);

        for (int i = 0; i < cityList.size(); i++) {
            cityList.get(i);
        }
        return JsonUtils.objectToJson(cityList);
    }
}
