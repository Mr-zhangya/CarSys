package com.demo.carsys.controller;

import com.demo.carsys.entity.City;
import com.demo.carsys.service.CityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/city")
public class CityController {
    private static final Logger logger = LogManager.getLogger(CityController.class);
    @Autowired
    CityService cityService;

    @RequestMapping("/citys")
    @ResponseBody
    public City citys(Integer getid, Integer backid) {
        logger.info("++++++++++++++++取车地点ID+++++++++++++++");
        logger.info(getid);
        logger.info("++++++++++++++++++++++++++++++++++++++++");

        logger.info("---------------还车地点ID---------------");
        logger.info(backid);
        logger.info("----------------------------------------");
        String getCarCity = cityService.selectGetCarCityByPid(getid);
        String repayCarCity = cityService.selectRepayCarCityByPid(backid);

        City city = new City();
        city.setGetCarCity(getCarCity);
        city.setRepayCarCity(repayCarCity);
        return city;
    }

}
