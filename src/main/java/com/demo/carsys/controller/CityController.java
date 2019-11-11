package com.demo.carsys.controller;

import com.demo.carsys.entity.City;
import com.demo.carsys.service.CityService;
import com.demo.carsys.utils.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/city")
public class CityController {
    private static final Logger logger = LogManager.getLogger(CityController.class);
    @Autowired
    CityService cityService;

    @RequestMapping("/citys")
    @ResponseBody
    public City citys(Integer getid, Integer backid) {
        logger.info(getid);
        logger.info(backid);
        String getCarCity = cityService.selectGetCarCityByPid(getid);
        String repayCarCity = cityService.selectRepayCarCityByPid(backid);
        /*Map<String ,String> map = new HashMap<String, String>();
        map.put("getCarCity",getCarCity);
        map.put("repayCarCity",repayCarCity);
        map.put("data","success");*/
        City city = new City();
        city.setGetCarCity(getCarCity);
        city.setRepayCarCity(repayCarCity);
        return city;
    }

}
