package com.demo.carsys.controller;

import com.demo.carsys.entity.Car;
import com.demo.carsys.service.CarService;
import com.demo.carsys.utils.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private static final Logger logger = LogManager.getLogger(CarController.class);

    @Autowired
    CarService carService;

    @RequestMapping("/price")
    public String priceSort(Integer getid,Integer backid) {
        logger.info("*******************************************************************");
        logger.info(getid);
        logger.info("*******************************************************************");
        List<Car> list = carService.priceSort(getid);
        logger.info("*******************************************************************");
        logger.info(list);
        logger.info("*******************************************************************");
        return JsonUtils.objectToJson(list);
    }

    @RequestMapping("/number")
    public String numberSort(Integer getid,Integer backid) {
        logger.info("--------------------------------------------------------------------");
        logger.info(backid);
        logger.info("--------------------------------------------------------------------");
        List<Car> list = carService.numberSort(getid);
        logger.info("--------------------------------------------------------------------");
        logger.info(list);
        logger.info("--------------------------------------------------------------------");
        return JsonUtils.objectToJson(list);
    }
}
