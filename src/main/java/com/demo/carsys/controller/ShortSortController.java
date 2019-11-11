package com.demo.carsys.controller;

import com.demo.carsys.service.ShortSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sort")
public class ShortSortController {

    @Autowired
    ShortSortService shortSortService;

    @RequestMapping("/shortSort")
    public String shortSortCar() {
        return "shortsort";
    }
}
