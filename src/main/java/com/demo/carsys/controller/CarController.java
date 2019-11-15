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
        logger.info("******************************取车地点 id ****************************");
        logger.info(getid);
        logger.info("*******************************************************************");
        List<Car> list = carService.priceSort(getid);
        logger.info("*****************按照 price 对取车地点的所有车辆进行排序***************");
        logger.info(list);
        logger.info("*******************************************************************");
        return JsonUtils.objectToJson(list);
    }

    @RequestMapping("/number")
    public String numberSort(Integer getid,Integer backid) {
        logger.info("------------------------------还车地点ID-----------------------------");
        logger.info(backid);
        logger.info("--------------------------------------------------------------------");
        List<Car> list = carService.numberSort(getid);
        logger.info("------------------按照 number 对取车地点的所有车辆进行排序---------------");
        logger.info(list);
        logger.info("--------------------------------------------------------------------");
        return JsonUtils.objectToJson(list);
    }

    @RequestMapping("/findcar")
    public Car findcar(Integer cid) {

        logger.info("////////////////////////////车的id/////////////////////////////////");
        logger.info(cid);
        logger.info("////////////////////////////////////////////////////////////////////");

        Car car;
        car = carService.findCar(cid);

        logger.info("+++++++++++++++++++++++++++车的信息+++++++++++++++++++++++++++++++++++");
        logger.info(car);
        logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        return car;
    }
}
