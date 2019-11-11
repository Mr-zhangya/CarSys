package com.demo.carsys.service.impl;

import com.demo.carsys.entity.City;
import com.demo.carsys.mapper.ShortRentMapper;
import com.demo.carsys.service.ShortRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortRentServiceImpl implements ShortRentService {

    @Autowired
    ShortRentMapper shortRentMapper;

    public List<City> shortRentCityList() {
        List<City> cityList = shortRentMapper.shortRentCityList();


       /* for (int i = 0; i < cityList.size(); i++) {
            Integer id = cityList.get(i).getId();
            shortRentMapper.shortRentList(id);
        }*/

        return cityList;
    }

    public List<City> shortRentList(int id) {
        return shortRentMapper.shortRentList(id);
    }
}
