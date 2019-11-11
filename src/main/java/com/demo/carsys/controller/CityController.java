package com.demo.carsys.controller;

import com.demo.carsys.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityService cityService;

    @RequestMapping("/citys")
    public String citys(Integer cityPid,Integer regionPid ) {
        //cityService.
        return "";
    }

}
