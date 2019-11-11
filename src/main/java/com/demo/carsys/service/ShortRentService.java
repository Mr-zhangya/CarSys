package com.demo.carsys.service;

import com.demo.carsys.entity.City;

import java.util.List;

public interface ShortRentService {

    List<City> selectCity(Integer pid);
}
