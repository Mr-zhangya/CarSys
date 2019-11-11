package com.demo.carsys.controller;
import com.demo.carsys.entity.City;
import com.demo.carsys.service.ShortRentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@RequestMapping("/ShortRent")
@Controller
public class ShortRentController {
    private static final Logger logger = LogManager.getLogger(UserController.class);


    @Autowired
    ShortRentService shortRentService;

    @RequestMapping("/shortRentList")
    public String shortRentList(Model model) {
        List<City> cityList = shortRentService.shortRentCityList();
        model.addAttribute(cityList);
        return "shortrent";
    }

    @RequestMapping("/shortList")
    @ResponseBody
    public String shortList(int id,Model model) {
        logger.info(id);
        List<City> shortList = shortRentService.shortRentList(id);
        for ( City city: shortList) {
            logger.info(city);
        }
        model.addAttribute(shortList);
        return "success";
    }
}
