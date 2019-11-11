package com.demo.carsys.service;

import com.demo.carsys.entity.City;

import java.util.List;

public interface CityService {
    String selectGetCarCityByPid(Integer getid);

    String selectRepayCarCityByPid(Integer backid);

    List<City> selectCitys();
}
